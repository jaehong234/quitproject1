
function addReplyTag(list) {

	let tag = ``;

	for (obj of list) {
		tag = tag + `
		<div>
			<div id="reply_id_id">댓글 아이디 : ${obj['id']}</div>
			댓글 내용 : ${obj['replyContent']}<br>
			<button class="reply_delete_btn" reply-id-data="${obj['id']}">삭제</button>
		</div>
		<hr>
		`
	}
	return tag;
}

