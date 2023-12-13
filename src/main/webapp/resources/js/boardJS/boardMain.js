/**
 * 
 */

var change = function(tag) {
	if(tag == "all") {	// 전체
		$(".feed").html(
				"<div class='feed_post'>" +
					"<div class='feed_card'>" +
						"<a href=''>" +
							"<div class='card_img'>" +
								"<img alt='게시물' src='../resources/image/boardIMG/all.png'>" +
							"</div>" +
							
							"<div class='card_id'>" +
								"<p>아이디</p>" +
							"</div>" +
							
							"<div class='card_title'>" +
								"<p>제목</p>" +
							"</div>" +
						"</a>" +
						
						"<a href=''>" +
						"<div class='card_img'>" +
							"<img alt='게시물' src='../resources/image/boardIMG/all.png'>" +
						"</div>" +
						
						"<div class='card_id'>" +
							"<p>아이디</p>" +
						"</div>" +
						
						"<div class='card_title'>" +
							"<p>제목</p>" +
						"</div>" +
					"</a>" +
					
					
					"</div>" +
				"</div>"
					
					// <div>쓰고 if(i%4 == 0 || next( == false </div>
		);
	} else if(tag == "ootd") {
		$(".feed").html(
				"<div class='feed_post'>" +
					"<div class='feed_card'>" +
						"<a href='post.jsp'>" +
							"<div class='card_img'>" +
								"<img alt='게시물' src='../resources/image/boardIMG/post.jpg'>" +
							"</div>" +
							
							"<div class='card_id'>" +
								"<p>아이디</p>" +
							"</div>" +
							
							"<div class='card_title'>" +
								"<p>제목</p>" +
							"</div>" +
						"</a>" +
					"</div>" +
				"</div>"
		);
	} else if (tag == "trend") {
		console.log(tag);
	} else if (tag == "street") {
		console.log(tag);
	} else if (tag == "casual") {
		console.log(tag);
	} else if (tag == "classic") {
		console.log(tag);
	} else if (tag == "vintage") {
		console.log(tag);
	}
}