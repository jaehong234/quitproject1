console.log("test2.js~~~~");

function replyListRender(obj){
	
	let tag =``;
	
	for(let el of obj) {
		tag +=`
			<tr>
				<th>댓글아이디</th>
				<td>${el.id}</td>
			</tr>
			<tr>
				<th>댓글내용</th>
				<td>
					<span>${el.replyContent}</span>
					<div id='readForm'>
						<button class="update_reply">댓글수정</button>
						<button class="del_reply">댓글삭제</button>
					</div>
					<div id='modForm' style="display: none;">
						<button class="modBtn">수정완료</button>
						<button class="backBtn">취소</button>
					</div>
				</td>
			</tr>
		`
	}
	
	$("#reply_list_tag").html(tag);
	
	
	$(".update_reply").each(function(){
		$(this).click(function(){
			$(this).parent().next().show();
			$(this).parent().hide();
			
			let orgContent = $(this).closest("td").find("span").text();
			let inputTag = $("<input>").attr("name", "replyContent").val(orgContent);
			let spanTag = $(this).closest("td").find("span");
			spanTag.text('');
			inputTag.appendTo(spanTag);
		});
	});
	
	$(".backBtn").click(function(){
		
		let orgContent = $(this).closest("td").find("span").text();
		let inputTag = $(this).closest("td").find("input");
		let spanTag = $(this).closest("td").find("span");
		inputTag.val(orgContent);
		
		
		spanTag.text();
		
		inputTag.remove();
		
		$(this).parent().hide();
		$(this).parent().prev().show();
		
		
	});
	/*$(".update_reply").each(function(){
		$(this).click(function(){
			let content = $(this).closest("td").find("span").text();
			let updateTag = $("<input>").attr("type", "button").attr("class", "reply_update_btn").val("수정완료");
			let inputTag = $("<input>").attr("name", "replyContent").val(content);
			
			$(this).closest("td").append(inputTag);
			$(this).closest("td").append(updateTag);
			
			$(".reply_update_btn").click(function(){
				let id = $(this).closest("tr").prev().find("td").text();
				
				$.ajax({
					url : "/replies/",
					type : "put",
					dataType : "text",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "PUT"
					},
					data : JSON.stringify({
						id : id,
						content : inputTag.val()
					}),
					success : function(result){
						getReplyList();
					}
				});
				
			});
			
		});
		
		
	});*/
	
	
	$(".del_reply").each(function(){
		$(this).click(function(){
			let id = $(this).closest("tr").prev().find("td").text();
			
			$.ajax({
					
					url : "/replies/",
					type : "delete",
					dataType : "text",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "DELETE"
					},
					data : JSON.stringify({
						id : id
					}),
					success : function(result){
						getReplyList();
					}
			});
		});
	});
}

function getReplyList(){
	
	let id = $("input[type='hidden']").val();
	
	$.ajax({
				url : "/replies/"+id,
				type : "get",
				dataType : "text",
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				success : function(result){
					let obj = JSON.parse(result);
					replyListRender(obj);
				}
				
			});
}


$(function(){
	
	getReplyList();
	
	$("#board_delete_btn").click(function(){
		let id = $("input[type='hidden']");
				let form = $("<form>");
				form.appendTo("body");
				form.attr("method","post").attr("action", "/board/delete").append(id).submit();
	});
	
	$("#reply_btn").click(function(){
		let id = $("input[type='hidden']").val();
		let content = $("input[name='replyContent']").val();
		$.ajax({
			url : "/replies/",
			type : "post",
			data : JSON.stringify({
				id : id,
				content : content
			}),
			dataType : "text",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			success : function(result){
				getReplyList();
			}
			
		});
		
		
		
		
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});