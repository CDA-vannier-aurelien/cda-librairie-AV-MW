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

<body onload="calculPrixTotal()"
	style="background-color: white; background: white;">
	<h1 class="text-center text-white d-none d-lg-block site-heading">
		<span class="site-heading-lower"
			style="font-family: Lora, serif; color: rgb(33, 37, 41);">La
			Librairie</span>
	</h1>

	<body style="background-color: white; background: white;">
	<%@include file="navbar.jsp"%>
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
												<div class="py-2 text-uppercase">Quantité</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Total</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Supprimer</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="l" items="${sessionScope.panier}">
											<tr>
												<th scope="row" class="border-0">
													<div class="p-2">
														<img
															src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg"
															alt="" width="70" class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">
																<a href="#"
																	class="text-dark d-inline-block align-middle">${l.key.titre }</a>
															</h5>
														</div>
													</div>
												</th>
												<td class="border-0 align-middle"><strong>${l.key.prix}
														€</strong></td>
												<td class="border-0 align-middle"><strong>${l.value}</strong></td>
												<td class="border-0 align-middle" name="totalLigne"
													value="${l.value*l.key.prix}"><strong>${l.value*l.key.prix} €</strong></td>

												<td class="border-0 align-middle">
													<form method="post" action="supprimerLigne"
														id="corbeille${l.key.reference }">
														<input type="hidden" value="${l.key.reference}"
															name="referenceSupprimee"> <a
															onclick="supprimerLigne(${l.key.reference })"
															class="text-dark submit"> <i class="fa fa-trash"></i>
														</a>
													</form>
												</td>
											</tr>
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
								<p class="font-italic mb-4">Si vous avez un coupon de
									réduction, insérez le code ici.</p>
								<div class="input-group mb-4 border rounded-pill p-2">
									<input type="text" placeholder="Apply coupon"
										aria-describedby="button-addon3" class="form-control border-0">
									<div class="input-group-append border-0">
										<button id="button-addon3" type="button"
											class="btn btn-dark px-4 rounded-pill">
											<i class="fa fa-gift mr-2"></i>Valider le coupon
										</button>
									</div>
								</div>
							</div>
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Nous
								conctacter</div>
							<div class="p-4">
								<p class="font-italic mb-4">Vous pouvez ajouter vos
									questions pour notre équipe dans le cadre suivant</p>
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
										class="text-muted">Sous-Total</strong><strong><span
											id="sousTotal"> </span> €</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">frais de livraison</strong><strong><span
											id="frais">10</span> €</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">TVA</strong><strong><span
											id="taxes"></span> €</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Total</strong>
										<h5 class="font-weight-bold">
											<span id="totalCommande"> </span> €
										</h5></li>
								</ul>
								<form action="commander" method="post">
									<input type="hidden" id="" name="" value="">


									<button id="button-addon4" type="submit"
										class="btn btn-dark px-4 rounded-pill">
										<i class="fa fa-gift mr-2"></i>Valider commande
									</button>
								</form>
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
