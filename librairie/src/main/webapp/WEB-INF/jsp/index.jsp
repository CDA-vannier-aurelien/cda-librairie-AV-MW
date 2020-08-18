<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Home - Brand</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/styles.min.css">
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
						href="index.jsp" data-toggle="tooltip" data-placement="top"
						title="Accueil">Home</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="../about.html" data-toggle="tooltip" data-placement="top"
						title="A propos">A propos</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="../products.html" data-toggle="tooltip" data-placement="top"
						title="Produits">Produits</a></li>
					<li class="nav-item" role="presentation" data-toggle="tooltip"
						data-bs-tooltip="" data-placement="left"><a class="nav-link"
						href="../store.html">Store</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="../dashboard.html">dashboard</a></li>

				<c:if test="${empty sessionScope.user }">
						<li class="nav-item" role="presentation"><a class="nav-link"
							data-toggle="modal" data-target="#modalLRForm">Login</a></li>
				</c:if>
					<c:if test="${!empty sessionScope.user }">
					<button type="submit">Logout</button>
					</c:if>
		
			


				</ul>
			</div>
		</div>
	</nav>
	<section class="text-dark page-section clearfix">
		<div class="container">
			<div class="intro">
				<img class="img-fluid intro-img mb-3 mb-lg-0 rounded"
					src="assets/img/bevis-g-X0uh2_9YOUk-unsplash.jpg">
				<div
					class="intro-text left-0 text-centerfaded p-5 rounded bg-faded text-center">
					<h2 class="section-heading mb-4">
						<span class="section-heading-upper">La librairie</span><span
							class="section-heading-lower">Worth Drinking</span>
					</h2>
					<p class="mb-3">Bienvenue dans notre projet de librairie. Vous
						pourrez trouver tout type d'ouvrages fortement recommandés par
						notre équipe de développeurs sur doués.</p>
				</div>
			</div>
		</div>
	</section>
	<section class="card-section-imagia">
		<h1>Notre équipe de Développeurs</h1>
		<h2>Un truc</h2>
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="card-container-imagia">
						<div class="card-imagia">
							<div class="front-imagia">
								<div class="cover-imagia">
									<img alt="" src="https://unsplash.it/720/500?image=1067">
								</div>
								<div class="user-imagia">
									<img class="img-circle" alt=""
										src="https://unsplash.it/120/120?image=64">
								</div>
								<div class="content-imagia">
									<h3 class="name-imagia">Matthieu Waroux</h3>
									<p class="subtitle-imagia">Maître Canard en chef!</p>
									<p class="text-center">
										<em>Coin coin coin!</em>
									</p>
								</div>
								<div class="footer-imagia">
									<span><i class="fa fa-plus"></i> More info</span>
								</div>
							</div>
							<div class="back-imagia">
								<div class="content-imagia content-back-imagia">
									<div>
										<h3 class="text-center">Lorem Ipsum</h3>
										<p class="text-center">Et hanc quidem praeter oppida multa
											duae civitates exornant Seleucia opus Seleuci regis, et
											Claudiopolis quam deduxit coloniam Claudius Caesar. Isaura
											enim antehac nimium potens, olim subversa ut rebellatrix
											interneciva aegre vestigia claritudinis pristinae monstrat
											admodum pauca.</p>
									</div>
								</div>
								<div class="footer-imagia">
									<div class="social-imagia text-center">
										<a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i
											class="fa fa-linkedin"></i></a><a href="#"><i
											class="fa fa-twitter"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="card-container-imagia">
						<div class="card-imagia">
							<div class="front-imagia">
								<div class="cover-imagia cover-gradient"></div>
								<div class="user-imagia">
									<img class="img-circle" alt=""
										src="https://unsplash.it/120/120?image=64">
								</div>
								<div class="content-imagia">
									<h3 class="name-imagia">Aurélien Vannier</h3>
									<p class="subtitle-imagia">Mousse en chef</p>
									<p class="text-center">
										<em>Je casse le code comme le dos des gens. </em>
									</p>
								</div>
								<div class="footer-imagia">
									<span><i class="fa fa-plus"></i> More info</span>
								</div>
							</div>
							<div class="back-imagia">
								<div class="content-imagia content-back-imagia">
									<div>
										<h3 class="text-center">Lorem Ipsum</h3>
										<p class="text-center">Et hanc quidem praeter oppida multa
											duae civitates exornant Seleucia opus Seleuci regis, et
											Claudiopolis quam deduxit coloniam Claudius Caesar. Isaura
											enim antehac nimium potens, olim subversa ut rebellatrix
											interneciva aegre vestigia claritudinis pristinae monstrat
											admodum pauca.</p>
									</div>
								</div>
								<div class="footer-imagia">
									<div class="social-imagia text-center">
										<a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i
											class="fa fa-linkedin"></i></a><a href="#"><i
											class="fa fa-twitter"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 col-xl-4">
					<div class="card-container-imagia">
						<div class="card-imagia">
							<div class="front-imagia">
								<div class="cover-imagia">
									<img alt="" src="https://unsplash.it/720/500?image=1067">
								</div>
								<div class="user-imagia">
									<img class="img-circle" alt=""
										src="https://unsplash.it/120/120?image=64">
								</div>
								<div class="content-imagia">
									<h3 class="name-imagia">Fethi Benseddik</h3>
									<p class="subtitle-imagia">El Presidente $$$$</p>
									<p class="text-center">
										<em> On ne compte plus sa fortune en petits pains </em>
									</p>
								</div>
								<div class="footer-imagia">
									<span><i class="fa fa-plus"></i> More info</span>
								</div>
							</div>
							<div class="back-imagia">
								<div class="content-imagia content-back-imagia">
									<div>
										<h3 class="text-center">Lorem Ipsum</h3>
										<p class="text-center">Et hanc quidem praeter oppida multa
											duae civitates exornant Seleucia opus Seleuci regis, et
											Claudiopolis quam deduxit coloniam Claudius Caesar. Isaura
											enim antehac nimium potens, olim subversa ut rebellatrix
											interneciva aegre vestigia claritudinis pristinae monstrat
											admodum pauca.</p>
									</div>
								</div>
								<div class="footer-imagia">
									<div class="social-imagia text-center">
										<a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i
											class="fa fa-linkedin"></i></a><a href="#"><i
											class="fa fa-twitter"></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer class="footer text-faded text-center py-5"
		style="background-color: rgb(238, 244, 247); position: relative;">
		<div class="container">
			<p class="m-0 small" style="color: rgb(102, 109, 112);">Copyright&nbsp;©&nbsp;
				librairie2020</p>
		</div>
	</footer>
	<!--Modal: Login / Register Form-->
	<div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog cascading-modal" role="document">
			<!--Content-->
			<div class="modal-content">

				<!--Modal cascading tabs-->
				<div class="modal-c-tabs">

					<!-- Nav tabs -->
					<ul class="nav nav-tabs md-tabs tabs-2 light-blue darken-3"
						role="tablist">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#panel7" role="tab"><i
								class="fa fa-user-circle"></i> Login</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#panel8" role="tab"><i class="fa fa-user-plus"></i>
								Register</a></li>
					</ul>

					<!-- Tab panels -->
					<div class="tab-content">
						<!--Panel 7-->

						<div class="tab-pane fade in show active" id="panel7"
							role="tabpanel">

							<!--Body-->
							<form method="post" action="connection" class="was-validated"
								novalidate>
								<div class="modal-body mb-1">
									<div class="md-form form-sm mb-5">
										<i class="fa fa-envelope"></i> <input type="email"
											id="modalLRInput10"
											class="form-control form-control-sm validate" name="login">
										<label data-error="wrong" data-success="right"
											for="modalLRInput10">Your email</label>
									</div>

									<div class="md-form form-sm mb-4">
										<i class="fa fa-lock"></i> <input type="password"
											id="modalLRInput11"
											class="form-control form-control-sm validate" name="password">
										<label data-error="wrong" data-success="right"
											for="modalLRInput11">Your password</label>
									</div>
									<div class="text-center mt-2">
										<button class="btn btn-info">
											Log in <i class="fa fa-sign-in ml-1"></i>
										</button>
									</div>
								</div>
							</form>
							<!--Footer-->
							<div class="modal-footer">

								<button type="button"
									class="btn btn-outline-info waves-effect ml-auto"
									data-dismiss="modal">Close</button>
							</div>

						</div>
						<!--/.Panel 7-->

						<!--Panel 8-->
						<div class="tab-pane fade" id="panel8" role="tabpanel">

							<!--Body-->
							<form method="post" action="inscription" class="was-validated">
								<div class="modal-body">
									<div class="container-fluid">
										<div class="row">
											<div class="col md-form form-sm mb-2">
												<i class="fa fa-user prefix"></i> <input type="text"
													id="nom" class="form-control form-control-sm validate"
													placeholder="Nom" name="nom" required>

											</div>
											<div class="col md-form form-sm mb-2 mt-4">
												<input type="text" id="prenom"
													class="form-control form-control-sm validate"
													placeholder="Prenom" name="prenom" required>

											</div>
										</div>
										<div class="row">
											<div class="col-3 md-form form-sm mb-2">
												<i class="fa fa-home"></i> <input type="number" id="numero"
													class="form-control form-control-sm validate"
													placeholder="N°" name="numeroPorte" required>

											</div>
											<div class="col-9 md-form form-sm mb-2 mt-4">

												<input type="text" id="adresse"
													class="form-control form-control-sm validate"
													placeholder="Nom de la rue" name="nomRue" required>

											</div>
										</div>
										<div class="row">
											<div class="col md-form form-sm mb-2">
												<i class="fa fa-location-arrow prefix"></i> <input
													type="text" id="ville" name="ville"
													class="form-control form-control-sm validate"
													placeholder="Ville" required>

											</div>
											<div class="col md-form form-sm mb-2 mt-4">
												<input type="number" id="codePostal"
													class="form-control form-control-sm validate"
													placeholder="Code Postal" name="codePostal" required>

											</div>
										</div>
										<div class="md-form form-sm mb-2">
											<i class="fa fa-calendar-minus-o prefix"></i> <input
												type="date" id="datenaiss"
												class="form-control form-control-sm validate"
												placeholder="Date de Naissance" name="dateNaissance"
												required>

										</div>
										<div class="md-form form-sm mb-2">
											<i class="fa fa-envelope prefix"></i> <input type="email"
												id="email" class="form-control form-control-sm validate"
												onchange="testEmail()" name="mail" placeholder="Email"
												required> <span class="error text-danger"
												id="result"></span>
										</div>

										<div class="md-form form-sm mb-2">
											<i class="fa fa-lock prefix"></i> <input type="password"
												id="password" class="form-control form-control-sm validate"
												placeholder="Password" name="password" required>
										</div>

										<div class="text-center form-sm mt-2 mb-4">
											<button class="btn btn-info" id="valider">
												Sign up <i class="fa fa-sign-in ml-1"></i>
											</button>
										</div>

									</div>
									<!--Footer-->
									<div class="modal-footer">
										<button type="button"
											class="btn btn-outline-info waves-effect ml-auto"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</form>
						</div>
						<!--/.Panel 8-->
					</div>

				</div>
			</div>
			<!--/.Content-->
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/script.min.js"></script>
	<script src="assets/js/myScript.js"></script>
</body>

</html>