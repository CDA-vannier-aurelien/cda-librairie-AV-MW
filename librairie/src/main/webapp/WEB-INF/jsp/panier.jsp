<%--
  Created by IntelliJ IDEA.
  User: fethi
  Date: 10/08/2020
  Time: 07:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Home - Brand</title>
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i">
<link rel="stylesheet"
	href="<c:url value="/assets/fonts/font-awesome.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/css/styles.min.css"/>">
</head>

<body style="background-color: white; background: white;">
	<h1 class="text-center text-white d-none d-lg-block site-heading">
		<span class="site-heading-lower"
			style="font-family: Lora, serif; color: rgb(33, 37, 41);">La
			Librairie</span>
	</h1>

	<nav
		class="navbar navbar-light navbar-expand-md sticky-top bg-dark py-lg-4"
		id="mainNav">
		<div class="container-fluid">
			<a class="navbar-brand text-uppercase d-lg-none text-expanded"
				href="#" style="color: rgba(255, 255, 255, 0.7);">La Librarie</a>
			<button data-toggle="collapse" data-target="#navbarResponsive"
				class="navbar-toggler" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="nav navbar-nav mx-auto">
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="index">Home</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="listeLivre">Produits</a></li>
					<c:if test="${sessionScope.user.labelRole == 'Libraire'}">
						<li class="nav-item" role="presentation"><a class="nav-link"
							href="dashboard">Dashboard</a></li>
					</c:if>
					<c:if test="${empty sessionScope.user }">
						<li class="nav-item" role="presentation"><a class="nav-link"
							data-toggle="modal" data-target="#modalLRForm">Login</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.user }">

						<li class="nav-item dropdown"><a
							class="dropdown-toggle nav-link" data-toggle="dropdown"
							aria-expanded="false" href="#">${sessionScope.user.nom} </a>
							<div class="dropdown-menu" role="menu">
								<a class="dropdown-item" role="presentation" href="#">Mon
									compte</a> <a class="dropdown-item" role="presentation"
									href="panier">Mon panier</a><a class="dropdown-item"
									role="presentation" href="deconnexion">LogOut</a>
							</div></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Titre</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Prix</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Quantite</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Remove</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row" class="border-0">
												<div class="p-2">
													<img
														src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg"
														alt="" width="70" class="img-fluid rounded shadow-sm">
													<div class="ml-3 d-inline-block align-middle">
														<h5 class="mb-0">
															<a href="#" class="text-dark d-inline-block align-middle">Timex
																Unisex Originals</a>
														</h5>
														<span
															class="text-muted font-weight-normal font-italic d-block">Category:
															Watches</span>
													</div>
												</div>
											</th>
											<td class="border-0 align-middle"><strong>$79.00</strong></td>
											<td class="border-0 align-middle"><strong>3</strong></td>
											<td class="border-0 align-middle"><a href="#"
												class="text-dark"><i class="fa fa-trash"></i></a></td>
										</tr>
										<c:forEach var="l" items="${livre}">
											<tr>
												<th scope="row" class="border-0">
												<div class="p-2">
													<img
														src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg"
														alt="" width="70" class="img-fluid rounded shadow-sm">
													<div class="ml-3 d-inline-block align-middle">
														<h5 class="mb-0">
															<a href="#" class="text-dark d-inline-block align-middle">Timex
																Unisex Originals</a>
														</h5>
														<span
															class="text-muted font-weight-normal font-italic d-block">Category:
															Watches</span>
													</div>
												</div>
											</th>
												<td class="border-0 align-middle"><strong>${l.prix}</strong></td>
												<td class="border-0 align-middle"><strong>${l.quantite}</strong></td>									
												<td class="border-0 align-middle"><a href="#"
												class="text-dark"><i class="fa fa-trash"></i></a></td>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">
						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon
								code</div>
							<div class="p-4">
								<p class="font-italic mb-4">If you have a coupon code,
									please enter it in the box below</p>
								<div class="input-group mb-4 border rounded-pill p-2">
									<input type="text" placeholder="Apply coupon"
										aria-describedby="button-addon3" class="form-control border-0">
									<div class="input-group-append border-0">
										<button id="button-addon3" type="button"
											class="btn btn-dark px-4 rounded-pill">
											<i class="fa fa-gift mr-2"></i>Apply coupon
										</button>
									</div>
								</div>
							</div>
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions
								for seller</div>
							<div class="p-4">
								<p class="font-italic mb-4">If you have some information for
									the seller you can leave them in the box below</p>
								<textarea name="" cols="30" rows="2" class="form-control"></textarea>
							</div>
						</div>
						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order
								summary</div>
							<div class="p-4">
								<p class="font-italic mb-4">Shipping and additional costs
									are calculated based on values you have entered.</p>
								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Order Subtotal </strong><strong>$390.00</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Shipping and handling</strong><strong>$10.00</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tax</strong><strong>$0.00</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Total</strong>
										<h5 class="font-weight-bold">$400.00</h5></li>
								</ul>
								<a href="#" class="btn btn-dark rounded-pill py-2 btn-block">Procceed
									to checkout</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<footer class="footer text-faded text-center py-5"
		style="background-color: rgb(238, 244, 247); position: relative;">
		<div class="container">
			<p class="m-0 small" style="color: rgb(102, 109, 112);">Copyright&nbsp;©&nbsp;Brand
				2020</p>
		</div>
	</footer>
	<!--Modal: Login / Register Form-->


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="<c:url value="/assets/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/assets/js/script.min.js"/>"></script>
	<script src="<c:url value="/assets/js/myScript.js"/>"></script>
</body>

</html>
