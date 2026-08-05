<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Details | Learning Portal</title>

<!-- Google Fonts for modern typography -->
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

<style>

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Inter', sans-serif;
}

body {
    background: #f8fafc;
    color: #1e293b;
    line-height: 1.5;
}

.container {
    max-width: 1200px;
    width: 90%;
    margin: 40px auto;
    display: flex;
    gap: 32px;
    align-items: flex-start;
}

/* Left Section Styles */
.left-section {
    flex: 2;
    background: #ffffff;
    padding: 36px;
    border-radius: 16px;
    box-shadow: 0 4px 20px -2px rgba(0, 0, 0, 0.05);
    border: 1px solid #e2e8f0;
}

.course-title {
    font-size: 32px;
    font-weight: 700;
    margin-bottom: 16px;
    color: #0f172a;
    letter-spacing: -0.5px;
}

.course-description {
    color: #475569;
    font-size: 16px;
    line-height: 1.7;
    margin-bottom: 24px;
}

.info-box {
    display: flex;
    flex-wrap: wrap;
    gap: 16px;
    background: #f1f5f9;
    padding: 16px 20px;
    border-radius: 12px;
    margin-top: 24px;
    border: 1px solid #e2e8f0;
}

.info-box p {
    margin: 0;
    font-size: 14px;
    color: #334155;
}

.info-box strong {
    color: #0f172a;
}

.section-title {
    margin: 32px 0 16px;
    font-size: 20px;
    font-weight: 600;
    color: #0f172a;
    border-bottom: 2px solid #f1f5f9;
    padding-bottom: 8px;
}

.left-section ul {
    list-style: none;
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 12px;
}

.left-section ul li {
    position: relative;
    padding-left: 24px;
    color: #334155;
    font-size: 15px;
}

.left-section ul li::before {
    content: "✓";
    position: absolute;
    left: 0;
    color: #10b981;
    font-weight: bold;
}

/* Right Section Styles */
.right-section {
    flex: 1;
}

.course-card {
    background: #ffffff;
    border-radius: 16px;
    padding: 24px;
    box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.08);
    position: sticky;
    top: 30px;
    border: 1px solid #e2e8f0;
}

.course-image {
    width: 100%;
    height: 200px;
    background: linear-gradient(135deg, #6366f1 0%, #4338ca 100%);
    border-radius: 12px;
    margin-bottom: 20px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    font-weight: 600;
    font-size: 18px;
    letter-spacing: 0.5px;
}

.price {
    font-size: 32px;
    color: #0f172a;
    font-weight: 700;
    margin-bottom: 20px;
}

.btn {
    width: 100%;
    padding: 14px;
    border: none;
    border-radius: 10px;
    font-size: 16px;
    font-weight: 600;
    cursor: pointer;
    margin-bottom: 12px;
    transition: all 0.2s ease-in-out;
}

.buy-btn {
    background: #6366f1;
    color: white;
    box-shadow: 0 4px 12px rgba(99, 102, 241, 0.3);
}

.buy-btn:hover {
    background: #4f46e5;
    transform: translateY(-1px);
}

.cart-btn {
    background: #ffffff;
    color: #4f46e5;
    border: 2px solid #e0e7ff;
}

.cart-btn:hover {
    background: #eef2ff;
}

.features {
    margin-top: 24px;
    border-top: 1px solid #f1f5f9;
    padding-top: 20px;
}

.features h3 {
    font-size: 16px;
    font-weight: 600;
    margin-bottom: 14px;
    color: #0f172a;
}

.features ul {
    list-style: none;
}

.features ul li {
    margin-bottom: 10px;
    font-size: 14px;
    color: #475569;
}

/* Responsive adjustments */
@media (max-width: 768px) {
    .container {
        flex-direction: column;
    }
    .left-section ul {
        grid-template-columns: 1fr;
    }
}

</style>

</head>
<body>

<div class="container">

    <div class="left-section">

        <h1 class="course-title">${course.title}</h1>

        <p class="course-description">
            ${course.description}
        </p>

        <div class="info-box">
            <p><strong>Category:</strong> ${course.category}</p>
            <p><strong>Level:</strong> ${course.level}</p>
            <p><strong>Instructor:</strong> ${instructorName}</p>
        </div>

        <h2 class="section-title">What You'll Learn</h2>

        <ul>
            <li>Master the fundamentals</li>
            <li>Build real-world projects</li>
            <li>Understand best practices</li>
            <li>Gain practical experience</li>
        </ul>

        <h2 class="section-title">Course Requirements</h2>

        <ul>
            <li>Basic computer knowledge</li>
            <li>Internet connection</li>
            <li>Willingness to learn</li>
        </ul>

    </div>

    <div class="right-section">

        <div class="course-card">

            <div class="course-image">
                Course Preview
            </div>

            <div class="price">
                ₹${course.price}
            </div>

            <input type="hidden"
       			id="courseId"
       			value="${course.id}">

			<input type="hidden"
      		     id="price"
       			 value="${course.price}">

	<button
       		type="button"
        	class="btn buy-btn"
       		onclick="payNow()">

    		Enroll Now

	</button>

            <button class="btn cart-btn">
                Add To Wishlist
            </button>

            <div class="features">

                <h3>This Course Includes</h3>

                <ul>
                    <li>📹 Video Lectures</li>
                    <li>📄 Downloadable Notes</li>
                    <li>📝 Assignments</li>
                    <li>📱 Mobile Access</li>
                    <li>🏆 Certificate of Completion</li>
                    <li>♾ Lifetime Access</li>
                </ul>

            </div>

        </div>

    </div>

</div>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script>

<script>

function payNow(){

    let price =
        document.getElementById("price").value;

    fetch(
        "createOrder",
        {
            method:"POST",
            headers:{
                "Content-Type":
                "application/x-www-form-urlencoded"
            },
            body:"price="+price
        }
    )

    .then(response => response.json())

    .then(order => {

        var options = {

            key:"rzp_test_TKbMXDWDdnRvul",
            amount:order.amount,
            currency:order.currency,
            order_id:order.id,
            name:"Coding Academy",
            description:"Course Purchase",
            
            handler:function(response){
            
                let courseId =document.getElementById("courseId").value;
                
                fetch("verifyPayment",{
                	method:"POST",
                	headers:{
                		"Content-Type":"application/x-www-form-urlencoded"
                	},
                	body:
                		"paymentId=" + response.razorpay_payment_id +
                		"&orderId=" + response.razorpay_order_id +
                        "&signature=" + response.razorpay_signature +
                        "&courseId=" + courseId
                })
                .then(res=>res.text())
                .then(data=>{
                	if(data==="success"){
                		window.location = "myCourses"
                	} else{
                		alert("payment verification failed");
                	}
                });

                //window.location ="enrollCourse?courseId=" + courseId;
            }
        };

        var rzp = new Razorpay(options);

        rzp.open();

    }) .catch(error => {

        console.log(error);

        alert("Unable to create payment");

    });
}

</script>

</body>
</html>