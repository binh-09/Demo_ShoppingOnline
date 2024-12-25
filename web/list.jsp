<%-- 
    Document   : list
    Created on : Dec 19, 2024, 9:23:46 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/style.css">
        <script type="text/javascript">
            function setCheck(obj) {
                var fries = document.getElementsByName('cidd');
                if (obj.categoryID === 'c0' && fries[0].checked === true) {
                    for (var i = 1; i < fries.length; i++) {
                        fries[i].checked = false;
                    }
                } else {
                    for (var i = 1; i < fries.length; i++) {
                        if (fries[i].checked === true) {
                            fries[0].checked = false;
                            break;
                        }
                    }
                }
                document.getElementById('f1').submit();
            }

            function setCheck1(obj) {
                var fries1 = document.getElementsByName('price');
                if (obj.categoryID === 'g0' && fries1[0].checked === true) {
                    for (var i = 1; i < fries1.length; i++) {
                        fries1[i].checked = false;
                    }
                } else {
                    for (var i = 1; i < fries1.length; i++) {
                        if (fries1[i].checked === true) {
                            fries1[0].checked = false;
                            break;
                        }
                    }
                }
                document.getElementById('f2').submit();
            }
        </script>
    </head>
    <body>
        <a href="home"><img src="img/home.png" width="40px" height="40px" alt="home"></a>
        <div class="topnav">
            <form action="home1" method="get">
                <input type="text" placeholder="Search...." name="key"/>
                <button onclick="this.form.submit()">
                    <img src="img/search.png" width="20px" height="16px" alt="search"/>
                </button>
            </form>
        </div>
        <div class="clr"></div>
        <div id="menu_tab">
            <c:set var="cat" value="${requestScope.data}"/>
            <c:set var="cid" value="${requestScope.cid}"/>
            <ul class="menu">
                <li><a class="${cid==0?"active":""}" href="home1?cid=${0}">ALL</a></li>
                    <c:forEach items="${cat}" var="c">
                    <li><a class="${c.categoryID==cid?"active":""}" href="home1?cid=${c.categoryID}">${c.categoryName}</a></li>
                    </c:forEach>
            </ul>
        </div>
        <div class="clr"></div>
        <div class="content">
            <div id="tab1">
                <c:set var="chid" value="${requestScope.chid}"/>
                <h5 style="color: chocolate">TÊN HÃNG</h5>
                <hr style="border-top: 1px solid chocolate"/>
                <form action="home1" id="f1">
                    <input type="checkbox" id="c0" name="cidd" ${chid[0]?"checked":""}
                           value="${0}" onclick="setCheck(this)"/>ALL<br/>
                    <c:forEach begin="0" end="${(cat.size()-1)}" var="i">
                        <input type="checkbox" id="cm" name="cidd"
                               ${cat.get(i).getCategoryID()==cid?"checked":""}
                               value="${cat.get(i).getCategoryID()}"
                               ${chid[i+1]?"checked":""} onclick="setCheck(this)"/>
                        ${cat.get(i).getCategoryName()}
                        <br/>
                    </c:forEach>
                </form>

                <h5 style="color:chocolate">Mức Giá</h5>
                <hr style="border-top: 1px solid chocolate"/>
                <c:set var="pp" value="${requestScope.pp}"/>
                <c:set var="pb" value="${requestScope.pb}"/>
                <form action="home1" id="f2">
                    <input type="checkbox" id="g0" name="price"
                           ${pb[0]?"checked":""}
                           value="0" onclick="setCheck1(this)"/>ALL<br/>
                    <c:forEach begin="0" end="${4}" var="i">
                        <input type="checkbox" id="g1" name="price"
                               ${(pb[(i+1)]?"checked":"")}
                               value="${(i+1)}" onclick="setCheck1(this)"/>${pp[i]}<br/>
                    </c:forEach>
                </form>
            </div>

            <div id="tab2">
                <c:set var="news" value="${requestScope.news}"/>
                <c:if test="${news!=null}">
                    <h4 style="color: chocolate">Products New</h4>
                    <ul class="item">
                        <c:forEach items="${news}" var="p">
                            <li>
                                <a href="#">
                                    <p>${p.productName}</p>
                                    <p>Gia Goc:<span class="old">${p.unitPrice*2.5}</span> USD</p>
                                    <p>Sale:${p.unitPrice}</p>
                                    <p>Hang Ton Kho:${p.unitsInStock}</p>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    <hr>
                </c:if>

                <c:set var="old" value="${requestScope.olds}"/>
                <c:if test="${old!=null}">
                    <h4 style="color: chocolate">Products Old</h4>
                    <ul class="item">
                        <c:forEach items="${old}" var="p">
                            <li>
                                <a href="#">
                                    <p>${p.productName}</p>
                                    <p>Gia Goc: <span class="ald">${p.unitPrice*2.5}</span> USD</p>
                                    <p>Sale: ${p.unitPrice}</p>
                                    <p>Hang Ton Kho:${p.unitsInStock}</p>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                    <hr/>
                </c:if>
                <c:set var="list" value="${requestScope.products}"/>
                <c:if test="${list!=null}">
                    <h4 style="color: chocolate">PRODCUT: ${list.size()}</h4>
                    <ul class="item">
                        <c:forEach items="${list}" var="p">
                            <li>
                                <a href="#">
                                    <p>${p.productName}</p>
                                    <p>Gia Goc: <span class="ald">${p.unitPrice*2.5}</span> USD</p>
                                    <p>Sale: ${p.unitPrice}</p>
                                    <p>Hang Ton Kho:${p.unitsInStock}</p>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
    </body>

</html>
