<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link 
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Stock Trading Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addEmp">Add Trade</a>
        </li>
      </ul> 
    </div>
  </div>
</nav>

	<div class="container">
		<div class ="row">
			<div class="col-md-6 offset-md-3 ">
			<div class="card">
			<div class="card-header text-center">
				<h3>Edit Trade</h3>
				<c:if test="${not empty msg}">
					<h5 class="text-success">${msg}</h5>
					<c:remove var="msg"/>
				</c:if>
			</div>
				<div class="card-body">
				<form action ="${pageContext.request.contextPath }/updateTrade" method="post">
					<input type="hidden" name="id" value="${trade.id }">
					<div class="mb-3">
						<label>Enter Trade Date Time: </label>
						<input type="datetime-local" name="tradeDateTime" class="form-control" value="${trade.tradeDateTime }">
					</div>
					
					<div class="mb-3">
						<label>Enter Stock Name: </label>
						<input type="text" name="stockName" class="form-control" value="${trade.stockName }">
					</div>
					
					<div class="mb-3">
						<label>Enter Listing Price: </label>
						<input type="number" name="listingPrice" class="form-control" value="${trade.listingPrice }">
					</div>
					
					<div class="mb-3">
						<label>Enter Quantity: </label>
						<input type="number" name="quantity" class="form-control" value="${trade.quantity }">
					</div>
					
					<div class="mb-3">
						
						<label >Enter Type (Buy/Sell):</label>
				        <select id="type" name="type" class="form-control" value="${trade.type }">
				            <option value="buy">Buy</option>
				            <option value="sell">Sell</option>
				        </select>
					</div>
					
					<div class="mb-3">
						<label>Enter Price Per Unit: </label>
						<input type="number" name="pricePerUnit" class="form-control" value="${trade.pricePerUnit }">
					</div>
					<div align="center">
						<button class="btn btn-primary">Update</button>
					</div>>
				</form>
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>