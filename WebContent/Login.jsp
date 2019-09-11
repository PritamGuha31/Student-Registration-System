<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body">
          <form role="form" method="post" action="login_request">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Email </label>
              <input type="email" class="form-control" name="email" placeholder="Enter email" required/>
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" name="password" placeholder="Enter password" required/>
            </div>
            <!-- <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div> -->
            <input type="submit" value="LOGIN" style="background-color: #000000; color: white; width: 535px; height: 35px;"> 
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Not a member? <a href="Reg1.jsp">Sign Up</a></p>
          <!-- <p>Forgot <a href="#">Password?</a></p> -->
        </div>
      </div>
    </div>
  </div> 