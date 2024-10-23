<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>
	<div class="container w-25">
		<table class="table table-bordered mt-5">
			<thead>
				<tr>
					<th scope="col">uid</th>
					<th scope="col">user</th>
					<th scope="col">pass</th>
					<th scope="col">isSeller</th>
					<th scope="col">isAdmin</th>
				</tr>
			</thead>
			<tbody style="user-select: none;">

				<c:forEach items="${users}" var="user">
					<tr>
						<th scope="row">${user.uid}</th>
						<td>${user.user}</td>
						<td>${user.pass}</td>
						<td>${user.isSeller}</td>
						<td>${user.isAdmin}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

		<ul class="pagination justify-content-center">
			<li class="previous" style="cursor: pointer; pointer-events: none; user-select: none;"><span
				class="page-link rounded-start-2">Previous</span></li>

			<c:forEach begin="1" end="${endPage}" var="i">
				<li class="page-item ${index == i ? "active" : "" }" data-index="${i}" style="cursor: pointer; user-select: none;"><span
					class="page-link">${i}</span></li>
			</c:forEach>

			<li class="next" style="cursor: pointer; user-select: none;"><span
				class="page-link rounded-end-2">Next</span></li>
		</ul>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js
"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
		integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		const pageItems = [...$(".page-item")];
		const prevPage = $(".previous")[0];
		const nextPage = $(".next")[0];
		const pageLength = pageItems.length;
		let currentIndex = <%=request.getAttribute("index")%> || 1;
		
		
		const getUserData = (index) => {
			$.ajax({
				url : "/Paging/load",
				type : "GET",
				data: {
					index: index
				},
				success : function(result) {
					var tbody = document.querySelector("tbody");
					tbody.innerHTML = result;
				}
			});
		}
		
		prevPage.addEventListener("click", (e) => {
			nextPage.style = "cursor: pointer; user-select: none;";
			
			pageItems.forEach(pageItem => {
				pageItem.classList.remove("active");
			});
			
			currentIndex--;
			pageItems[currentIndex - 1].classList.add("active");
			
			getUserData(currentIndex);
			
			if(currentIndex == 1) {
				e.currentTarget.style = "cursor: pointer; pointer-events: none; user-select: none;";
			}
		})
		
		nextPage.addEventListener("click", (e) => {
			prevPage.style = "cursor: pointer; user-select: none;";
			
			pageItems.forEach(pageItem => {
				pageItem.classList.remove("active");	
			});
			pageItems[currentIndex].classList.add("active");
					
			currentIndex++;
			
			getUserData(currentIndex);
			
			if(currentIndex == pageLength) {
				e.currentTarget.style = "cursor: pointer; pointer-events: none; user-select: none;";
			} 
		})
		
		pageItems.forEach(pageItem => {
			pageItem.addEventListener("click", (e) => {

				pageItems.forEach(pageItem => {
					pageItem.classList.remove("active");
				});
				
				e.currentTarget.classList.add("active");
				currentIndex = e.currentTarget.dataset.index;
				
				if(currentIndex == 1) {
					prevPage.style = "cursor: pointer; pointer-events: none; user-select: none;";
				} else {
					prevPage.style = "cursor: pointer; user-select: none;";
				}
				
				if(currentIndex == pageLength) {
					nextPage.style = "cursor: pointer; pointer-events: none; user-select: none;";
				} else {
					nextPage.style = "cursor: pointer; user-select: none;";
				}
				
				$.ajax({
					url : "/Paging/load",
					type : "GET",
					data: {
						index: e.currentTarget.dataset.index
					},
					success : function(result) {
						var tbody = document.querySelector("tbody");
						console.log(result);
						tbody.innerHTML = "";
						tbody.innerHTML = result;
					}
				});
			});
		});
	</script>
</body>
</html>
