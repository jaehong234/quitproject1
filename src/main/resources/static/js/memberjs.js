$(function(){
	
	// read
	$("#member_delete_btn").click(function(){
		let isOk = confirm("정말 삭제할꺼야?");
		
		if(isOk){
			$("form").submit();
		}
	});
	
	//insert
	
	$("#insert_checkId_btn").click(function(){
		$.ajax({
			
			url : "/member/checkId",
			type : "post",
			dataType : "text",
			data : {
				userId : $("input[name='userId']").val()
			},
			success : function(result){
				if(result=="ok") {
					$("#checkId_message").html("<div>사용가능합니다.</div>");
				}else{
				$("#checkId_message").html("<div>사용불가합니다.</div>");
				}
			}
			
		});
	});

	$("#insert_list_btn").click(function(){
		location.href= "/member/list";
	});
	
	
	
});