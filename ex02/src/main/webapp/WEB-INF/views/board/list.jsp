<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL 태그라이브러리 추가(출력과 포맷 활용) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board List Page
				<button id='regBtn' type="button" class="btn btn-xs pull-right" >
					<p style="color:#337ab7;">Register New Board</p>
				</button>
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>

					<c:forEach items="${list}" var="board">
						<tr>
							<td><c:out value="${board.bno}" /></td>
							<td><c:out value="${board.title}" /></td>
							<td><c:out value="${board.writer}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>

						</tr>
					</c:forEach>

				</table>

				<!-- Modal창 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal Title</h4>
							</div>
							<div class="modal-body">처리가 완료 되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->


			</div>
			<!--  end panel-body -->
		</div>
		<!-- end panel -->
	</div>
</div>
<!-- /.row -->

<!-- JQuery 처리 Modal -->
<!-- addFlashAttribute 로 만들어졌기 때문에 Session 에 데이터 보관,  
		한번도 사용된적 없다면 번호 호출, 그렇지않다면 ''빈값 반환 -->
<!-- checkModal() 함수는 파라미터에 따라 모달창을 보여주거나 내용을 수정한 뒤 보이도록 설계 -->		
<script type="text/javascript">
	$(document).ready(function() { //modal 창 띄우기
		var result = '<c:out value="${result}"/>';

		checkModal(result);
		
		function checkModal(result){
			if (result == ''){
				return;
			} 	
			if (parseInt(result) > 0 ){
				$(".modal-body").html("게시글 "+ parseInt(result) + " 번이 등록 되었습니다.");
			}
			
			$("#myModal").modal("show")
		}
	$("#regBtn").on("click", function(){ // 등록페이지 이동
		self.location ="/board/register";
	});		
		

	});
</script>


<%@include file="../includes/footer.jsp"%>


