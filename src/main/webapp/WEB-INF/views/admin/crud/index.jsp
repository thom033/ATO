<style>
  .boxCenter{
    display: flex;
    justify-content: center;
    font-family: 'Space Grotesk';
    font-weight: 600;
    color: black;
  }
  .boxCenter:hover{
    font-size: larger;
  }
</style>
<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">
      <h5 class="offcanvas-title" id="offcanvasExampleLabel">CRUD</h5>
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
      <div class="container">
        <div class="row mb-3 boxCenter">
          <a class="nav-link" href="/question/crud">Question/Reponse</a>
        </div>
        <div class="row mb-3 boxCenter">
          <a class="nav-link" href="#">Type de notification</a>
        </div>
      </div>
    </div>
</div>