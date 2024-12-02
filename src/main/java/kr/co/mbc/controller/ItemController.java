package kr.co.mbc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jakarta.validation.Valid;
import kr.co.mbc.dto.ItemDto;
import kr.co.mbc.dto.ItemResponse;
import kr.co.mbc.entity.AttachEntity;
import kr.co.mbc.service.ItemService;
import kr.co.mbc.utils.UploadFileUtils;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;

	@PostMapping("/delete")
	public String delete(String itemId) {

		System.out.println(itemId);

		itemService.deleteByItemId(itemId);

		return "redirect:/item/list";
	}

	@PostMapping("/update")
	public String update(ItemDto itemDto) {

		itemService.update(itemDto);

		ItemResponse itemResponse = itemService.findByItemName(itemDto.getItemName());

		return "redirect:/item/read/" + itemResponse.getItemId();
	}

	@GetMapping("/update/{itemId}")
	public String update(@PathVariable("itemId") String itemId, Model model) {

		ItemResponse itemResponse = itemService.findByItemId(itemId);

		model.addAttribute("itemResponse", itemResponse);

		return "item/update";
	}

	@GetMapping("/list")
	public void list(Model model) {

		List<ItemResponse> list = itemService.findAll();

		model.addAttribute("list", list);

	}

	@GetMapping("/read/{itemId}")
	public String read(@PathVariable("itemId") @ModelAttribute("itemId") String itemId, Model model) {

		ItemResponse itemResponse = itemService.findByItemId(itemId);

		List<AttachEntity> attachList = itemResponse.getAttachList();

		for(AttachEntity attachEntity : attachList) {
			
			String filename = attachEntity.getFilename();
			model.addAttribute("filename", filename);
		}

		model.addAttribute("itemResponse", itemResponse);

		return "/item/read";
	}

	
	@GetMapping("/download")
	public ResponseEntity<byte[]> download(String fullFilename) {
		ResponseEntity<byte[]> entity = null;

		InputStream in = null;
		String path = Paths.get("src/main/resources/static/upload").toAbsolutePath().toString();

		File target = new File(path, fullFilename);

		try {
			in = new FileInputStream(target);
			HttpHeaders headers = new HttpHeaders();

			String orgname = UploadFileUtils.getOrgname(fullFilename);

			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
						// 모르는 미디어타입을 정의할 때 사용함.
			String val = "attachment;filename=\"" + new String(orgname.getBytes("UTF-8"), "ISO-8859-1") + "\"";
																	// 인코딩-> UTF-8 -> ISO-8859-1 로 변환
			headers.add("Content-Disposition", val); // 위에 설정한 속성 val을 headers에 추가

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK); 
					// (실제내용(무조건 byte스트림으로 해야함.), headers, 상태코드)
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST); 
							// 상태코드만 뜨게 해줌
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return entity;
	}
	
	@PostMapping("/insert")
	public String insert(@Valid @ModelAttribute("itemDto") ItemDto itemDto, BindingResult bindingResult,
			MultipartHttpServletRequest mRequest) {

		if (bindingResult.hasErrors()) {

			return "redirect:/item/insert";
		}

		MultipartFile file = mRequest.getFile("quitfile");

		String fullFilename = UploadFileUtils.uploadFile(file);

		System.out.println(fullFilename);

		itemDto.setFilename(fullFilename);

		itemService.save(itemDto);

		return "redirect:/item/list";
	}

	@GetMapping("/insert")
	public void insert() {

	}

}
