<#include "parts/head.ftl">

<script>
        function U() {
            var a = document.getElementById('inputGroupSelect01').value;
            document.getElementById('userdata1').value = a;
            var date =new Date();
            var result=date.getFullYear() +"-"+ date.getMonth()+"-"+ date.getDate()+" "+ date.getHours()+":"+ date.getMinutes()+":"+ date.getSeconds();
            document.getElementById('dateClose').value= result;
            document.getElementById('dateOpen').value = result;
        };

        function M() {
            var a = document.getElementById('inputGroupSelect02').value;
            document.getElementById('modeldata1').value = a;
        };

        function B() {
            var a = document.getElementById('inputGroupSelect03').value;
            document.getElementById('branddata1').value = a;
        };
        function C() {
            var a = document.getElementById('inputGroupSelect04').value;
            document.getElementById('status').value = a;
        }

    </script>
     <script src="js/main.js"></script>
<#include  "parts/orderTableAdd.ftl">


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">№</th>
        <th scope="col">Цена</th>
        <th scope="col">О ремонта</th>
        <th scope="col">Серийный номер</th>
        <th scope="col">Поступление в ремонт</th>
        <th scope="col">Окончание ремонта</th>
        <th scope="col">Статус заказа</th>
        <th scope="col">Клиент</th>
        <th scope="col">Модель</th>
        <th scope="col">Марка</th>
        <th scope="col">Дефекты аппарата</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

    <#list message as messages>

        <tbody>
        <tr>
            <td>${messages.id}</td>
            <td>${messages.price}</td>
            <td>${messages.about_repair}</td>
            <td>${messages.serialnumber}</td>
            <td>${messages.date_Open}</td>
            <td>${messages.date_Close}</td>
            <td>${messages.statusOrder}</td>
            <td>${messages.users_id.surname}</td>
            <td>${messages.model_id.model}</td>
            <td>${messages.brand_id.brand}</td>
            <td>${messages.defects}</td>
            <td><a class="btn btn-primary mb-3"  data-toggle="collapse" href="#collapseExample${messages.id}" role="button" aria-expanded="false" aria-controls="collapseExample${messages.id}" ">
                    Редактировать
                </a>
                <div class="collapse" id="collapseExample${messages.id}">
                    <div class="form-group mt-3">
                        <form method="post" action="/updateOrder/${messages.id}" enctype="multipart/form-data">
                            <div class="form-group">
                                <input type="text" class="form-control" name="price" value="${messages.price}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="about_repair" value="${messages.about_repair}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="serialnumber" value="${messages.serialnumber}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="date_Open" value="${messages.date_Open?string("yyyy-MM-dd HH:mm:ss")}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="date_Close" value="${messages.date_Close?string("yyyy-MM-dd HH:mm:ss")}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="statusOrder" value="${messages.statusOrder}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="users_id" value="${messages.users_id.id}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="model_id" value="${messages.model_id.id}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="brand_id" value="${messages.brand_id.id}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="defects" value="${messages.defects}">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary" >Сохранить</button>
                            </div>
                        </form>
                    </div>
                </div></td>
            <td><form method="post" action="/deleteOrder/${messages.id}" enctype="multipart/form-data">
                    <button type="submit"  class="btn btn-primary">Удалить</button></form></td>

        </tr>
        </tbody>

    </#list>

</table>

<#include "parts/basement.ftl">