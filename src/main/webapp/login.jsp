<%@page contentType="text/html;application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
	<jsp:body>


		<div class="row">
			<div class="col-md-8">
				<section id="loginForm">
					<form method="post" action="j_security_check" class = "form-horizontal">

					<h2>Zaloguj się</h2>
					<hr />

					<div class="form-group">
						<label class="col-md-2 control-label">
							Login:
						</label>
						<div class="col-md-10">
							<input type="text" name="j_username" class = "form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">
							Hasło:
						</label>
						<div class="col-md-10">
							<input type="password" name="j_password" class = "form-control" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-offset-2 col-md-10">
							<input type="submit" value="Zaloguj" class="btn btn-default" />
						</div>
					</div>

					</form>
				</section>
			</div>
		</div>


	</jsp:body>
</t:layout>