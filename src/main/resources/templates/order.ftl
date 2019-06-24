<#include "parts/head.ftl">

<a class="btn btn-primary mt-3 mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить квитанцию
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="/addOrder" enctype="multipart/form-data">
            <div class="form-group">
                <input type="hidden" class="form-control" name="id" placeholder="№" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="price" placeholder="Цена ремонта">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="serialnumber" placeholder="Серийный номер">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="about_repair" placeholder="О выполненом ремонте">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="defects" placeholder="Дефекты аппарата">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="date_Open" placeholder="Поступление в ремонт">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="date_Close" placeholder="Дата окончания ремонта">
            </div>
            <div class="form-group">
                <select class="custom-select" id="inputGroupSelect02">
                    <option selected>Клиент</option>
                    <#list messageUsers as messagesUser>
                    <option name="users_id">${messagesUser.surname}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="model_id" placeholder="Модель">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="brand_id" placeholder="Марка">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="statusorder" placeholder="Статус заказа">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>


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
            <td>${messages.users_id.name}</td>
            <td>${messages.model_id.model}</td>
            <td>${messages.brand_id.brand}</td>
            <td>${messages.defects}</td>
            <td><a class="btn btn-primary mb-3"  data-toggle="collapse" href="#collapseExample${messages.id}" role="button" aria-expanded="false" aria-controls="collapseExample${messages.id}">
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
                                <input type="text" class="form-control" name="date_Open" value="${messages.date_Open}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="date_Close" value="${messages.date_Close}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="statusorder" value="${messages.statusOrder}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="users_id" value="${messages.users_id.name}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="model_id" value="${messages.model_id.model}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="brand_id" value="${messages.brand_id.brand}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="defects" value="${messages.defects}">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">Сохранить</button>
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