<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>
<div class="container">
	<div class="card o-hidden border-0 shadow-lg my-5">
		<div class="card-body p-0">

			<div class="row">
				<div class="col-lg-12">
					<div class="text-center">Board Register</div>
					<form role="form" action="/board/register" method="post">
						<div class="form-group">
							<label>Title</label><input class="form-control form-control-user"
								name="title">
						</div>
						<div class="form-group">
							<label>Text area</label>
							<textarea rows="3" name="content"></textarea>
						</div>
						<div class="form-group">
							<label>writer</label><input
								class="form-control form-control-user" name="writer">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
						<button type="reset" class="btn btn-default">Reset</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="../includes/footer.jsp"%>