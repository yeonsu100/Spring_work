<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/detail.jsp</title>
<jsp:include page="../include/resource.jsp"></jsp:include>
<style>
	/* 글 내용을 출력할 div에 적용할 css */
	.contents, table{
		width: 100%;
		border: 1px dotted #cecece;
		box-shadow: 3px 3px 5px 6px #ccc;
	}
	/* 글내용의 경계선 표시 */
	.content{
		border: 1px dotted #cecece;
	}
	/* 글안에 있는 첨부 이미지의 폭 제한 */
	.content img{
		max-width: 100%;
	}
	/* 댓글에 관련된 css */
	.comments ul{
		padding: 0;
		margin: 0;
		list-style-type: none;
	}
	.comments ul li{
		border-top: 1px solid #888; /* li 의 윗쪽 경계선 */
	}
	.comments dt{
		margin-top: 5px;
	}
	.comments dd{
		margin-left: 26px;
	}
	.comments form textarea, .comments form button{
		float: left;
	}
	.comments li{
		clear: left;
	}
	.comments form textarea{
		width: 85%;
		height: 100px;
	}
	.comments form button{
		width: 15%;
		height: 100px;
	}
	/* 댓글에 댓글을 다는 폼과 수정폼을 일단 숨긴다. */
	.comment form{
		display: none;
	}
	.comment{
		position: relative;
	}
	.comment .reply_icon{
		width: 8px;
		height: 8px;
		position: absolute;
		top: 10px;
		left: 30px;
	}
</style>
</head>
<body>
<jsp:include page="../include/navbar.jsp">
	<jsp:param value="cafe" name="category" />
</jsp:include>
<div class="container">
	<ol class="breadcrumb">
		<li><a href="list.do">Show all contents (List)</a></li>
		<li>Show detail of content</li>
	</ol>
	<h1>See a detail of article</h1>
	 
	<c:if test="${not empty keyword }">
		<p>The keyword (<strong>${keyword }</strong>) that you searched is here.</p>
	</c:if>
	
	<c:if test="${dto.prevNum ne 0 }">
		<a href="detail.do?num=${dto.prevNum }&condition=${condition}&keyword=${encodedKeyword}">Prev.</a>
	</c:if>
	<c:if test="${dto.nextNum ne 0 }">
		<a href="detail.do?num=${dto.nextNum }&condition=${condition}&keyword=${encodedKeyword}">Next.</a>
	</c:if>
	
	
	<table class="table table-bordered table-condensed table-hover">
		<colgroup>			<!-- 값을 다 더했을 때 12가 되도록 -->
			<col class="col-xs-3"/>
			<col class="col-xs-9"/>
		</colgroup>
			<tr>
				<th>No.</th>
				<td>${dto.num }</td>
			</tr>
			<tr>
				<th>Writer</th>
				<td>${dto.writer }</td>
			</tr>
			<tr>
				<th>Title</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${dto.regdate }</td>
			</tr>
		</table>
	<div class="contents">${dto.content }</div>
	<a href="list.do">Show all contents</a>
	
	<%-- 본인이 쓴 글일때만 수정기능이 작동하도록 이 링크를 조건부로 출력 (세션이용) --%>
	<c:if test="${sessionScope.id eq dto.writer }">
		<a href="updateform.do?num=${dto.num }">Revision</a>
		<a href="javascript:deleteConfirm()">Delete</a>
	</c:if>
	
	
	<div class="comments">
	<ul>
	<c:forEach items="${commentList }" var="tmp">
		<c:choose>
			<c:when test="${tmp.deleted ne 'yes' }">
				<li class="comment" id="comment${tmp.num }" <c:if test="${tmp.num ne tmp.comment_group }">style="padding-left:50px;"</c:if> >
					<c:if test="${tmp.num ne tmp.comment_group }">
						<img class="reply_icon" src="${pageContext.request.contextPath}/resources/images/re.gif"/>
					</c:if>
					<dl>
						<dt>
							<img src="${pageContext.request.contextPath}/resources/images/user_image.gif"/>
							<span>${tmp.writer }</span>
							<c:if test="${tmp.num ne tmp.comment_group }">
								to <strong>${tmp.target_id }</strong>
							</c:if>
							<span>${tmp.regdate }</span>
							<a href="javascript:" class="reply_link">Leave a Comment Message</a>
							<c:choose>
								<c:when test="${id eq tmp.writer }">
									<a href="javascript:" class="comment-update-link">Revision</a>&nbsp;&nbsp;
									<a href="javascript:deleteComment(${tmp.num })">Delete</a>
								</c:when>
								<c:otherwise>
									<a href="javascript:">Blind this User</a>
								</c:otherwise>
							</c:choose>
						</dt>
						<dd>
							<pre>${tmp.content }</pre>
						</dd>
					</dl>
					<form class="comment-insert-form" action="comment_insert.do" method="post">
						<input type="hidden" name="parentNum" value="${dto.num }" />
						<input type="hidden" name="parentId" value="${tmp.writer }" />
						<textarea name="content"><c:if test="${empty id }">Please sign in before leave a comment!</c:if></textarea>
						<button type="submit">SAVE</button>
					</form>	

					<c:if test="${id eq tmp.writer }">
						<form class="comment-update-form" action="comment_update.do">
							<input type="hidden" name="num" value="${tmp.num }" />
							<textarea name="content">${tmp.content }</textarea>
							<button type="submit">REVISION</button>
						</form>
					</c:if>
				</li>				
			</c:when>
			<c:otherwise>
				<li>It was deleted.</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	</ul>
	<div class="clearfix"></div>
		<div class="comment_form">
			<form action="comment_insert.do" method="post">
				<input type="hidden" name="parentNum" value="${dto.num }"/>
				<input type="hidden" name="parentId" value="${dto.writer }"/>
				<textarea name="content"><c:if test="${empty id }">Please sign in before leave a comment!</c:if></textarea>
				<button type="submit">SAVE</button>
			</form>
		</div>
	</div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>

<script>
	$(".comment-update-link").click(function(){
		$(this).parent().parent().parent().find(".comment-update-form").slideToggle(200);
	});
	
	// 댓글 수정 폼에 submit 이벤트가 일어났을때 호출되는 함수
	$(".comment-update-form").on("submit", function(){
		// "private/comment_update.do"
		var url=$(this).attr("action");
		// 폼에 작성된 내용을 query 문자열로 읽어온다.
		// num=댓글번호&content=댓글내용
		var data=$(this).serialize();
		//이벤트가 일어난 폼을 선택해서 변수에 담아 놓는다.
		var $this=$(this);
		$.ajax({
			url:url,
			method:"post",
			data:data,
			success:function(responseData){
				// responseData : {isSuccess:true}
				if(responseData.isSuccess){
					// 폼을 안보이게 한다 
					$this.slideUp(200);
					// 폼에 입력한 내용 읽어오기
					var content=$this.find("textarea").val();
					// pre 요소에 수정 반영하기 
					$this.parent().find("pre").text(content);
				}
			}
		});
		//폼 제출 막기 
		return false;
	});
	
	// 댓글 삭제를 눌렀을때 호출되는 함수
	function deleteComment(num){
		var isDelete=confirm("Are you sure delete this comment?");
		if(isDelete){
			$.ajax({
				url:"comment_delete.do",
				method:"post",
				data:{"num":num},
				success:function(responseData){
					if(responseData.isSuccess){
						var sel="#comment"+num;
						$(sel).text("It was deleted.");
					}
				}
			});
		}
	}
	
	// 폼에 submit 이벤트가 일어 났을때 실행할 함수 등록 
	$(".comments form").on("submit", function(){
		// 로그인 여부
		var isLogin=${not empty id};
		if(isLogin==false){
			alert("Please sign in before leave a comment!");
			location.href="${pageContext.request.contextPath}/users/loginform.do?url=${pageContext.request.contextPath}/cafe/detail.do?num=${dto.num}";
			return false;			// 폼 전송 막기 
		}
	});
	// 답글 달기 링크를 클릭했을때 실행할 함수 등록
	$(".comment .reply_link").click(function(){
		$(this)
		.parent().parent().parent()
		.find(".comment-insert-form")
		.slideToggle(200);
		
		if($(this).text()=="Reply"){
			$(this).text("Cacel");
		}else{
			$(this).text("Reply");
		}
	});


	function deleteConfirm(){
		var isDelete=confirm("Are you sure that you want a delete this article?");
		if(isDelete){
			location.href="delete.do?num=${dto.num }";
		}
	}

</script>

</body>
</html>