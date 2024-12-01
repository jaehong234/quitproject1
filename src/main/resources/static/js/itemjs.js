$(function() {
	
	//read
	$("#item_delete_btn").click(function(){
		let isOk = confirm("정말 삭제하시겠습니까?");
		if(isOk) {
			$("#hidden_form").submit();
		}
	});

	$("#item_update_btn").click(function(){
		let itemId = $("#hidden_itemId").val();
		location.href = "/item/update/"+itemId;
	});

	$("#item_list_btn").click(function(){
		location.href = "/item/list";
	});
	
	
	//insert
	$("#item_insert_list_btn").	click(function(){
		location.href = "/item/list";
	});
	
	
	$("input[type='file']").change(function(event){
		let filename = event.target.files[0].name;
		
		console.log(filename);
		
		let reader = new FileReader();
		reader.readAsDataURL(event.target.files[0]);
		
		reader.onload = function(event){
			let tag = addImage(event.target.result, filename);
			
			$("#filelist").append(tag);
		}
		
		
	});
});


function getOrgname(result) {
	// 2024/11/14/uuid___mbc___a.png
	
	let idx = result.indexOf("___mbc___")+"___mbc___".length;
	let orgname = result.substring(idx, );
	
	return orgname;
}

function addAttachList(result, parent){
	let orgname = getOrgname(result);
	
	let isOk =isImageFile(orgname);
	
	let tag = ``;
	
	if(isOk) {
		tag = `
		<div>
			<img width="100px" height="100px" src="/board/download?fullFilename=${result}">
		</div>
		<a class="fullFilename" href="/board/download?fullFilename=${result}">${orgname}</a>
		`
	}else{
		tag = `
		<div>
			<img width="100px" height="100px" src="/upload/img.png">
		</div>
			<a class="fullFilename" href="/board/download?fullFilename=${result}">${orgname}</a>
		`
	}
	
	parent.append(tag);
	
}

function isImageFile(filename) {//aa.bb.cc.PNG, 이미지 파일인지 여부 확인//aa.bb.cc.PNG, 이미지 파일인지 여부 확인
	
	let idx = filename.lastIndexOf(".") + 1;
	let fmt = filename.substring(idx);
	
	let arrFmt = ["png", "gif", "jpg", "jpeg"]; ;//확장자가 배열의 4 가지 형태일 때만 이미지 파일로 인정함.
	
	let isOk = false;
	
	for(let i=0; i<arrFmt.length; i++) {
		if(arrFmt[i] == fmt.toLowerCase()) { // 파일의 확장자가 대문자일 수도 있으므로 무조건 소문자로 만들어 arrFmt와 비교
			isOk = true;
			break; // 파일의 확장자명이 arrFmt의 하나와 일치하면 이미지 파일이라고 선언하고 반복문 빠져나가기
		}
	}
	return isOk;
}

function addImage(result, filename) {
	let isOk = isImageFile(filename);
	
	let tag= `<div class="uploadimage">`;
	
	if(isOk){// 이미지 파일일 때는 자기 자신을 보여줌
		tag = tag + `<img data-filename="${filename}" data-result="${result}" class="test" src="${result}" width="100px" height="100px">`
	}else{// 이미지 파일이 아닐 때는 우리가 만들어서 upload폴더에 넣은 img.png를 보여줌
		tag = tag + `<img data-filename="${filename}" data-result="${result}" class="test" src="/upload/img.png" width="100px" height="100px">`
	}
	tag = tag + `<p><button class="btn btn-danger btn-sm delete">X</button>${filename}</p>`
	
	tag = tag + "</div>"
	
	return tag;
}