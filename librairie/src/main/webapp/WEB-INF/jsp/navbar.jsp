<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="img/livre.jpg" alt="livre" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">${sessionScope.user.prenom}</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">${sessionScope.user.nom}</a>
    </li>
  </ul>
   <ul class="navbar-nav">
   <li>
  <a href="deconnexion" class="btn btn-outline-danger pull-right" role="button" >Log Out</a>
  </li>
  </ul>
</nav>