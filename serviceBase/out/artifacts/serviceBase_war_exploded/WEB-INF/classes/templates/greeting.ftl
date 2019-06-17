<#include "parts/common.ftl">
<#import "parts/pager.ftl" as p>


<a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить клиента
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="/" enctype="multipart/form-data">
            <div class="form-group">
                <input type="hidden" class="form-control" name="id" placeholder="№" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Имя">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="surname" placeholder="Фамилия">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="patronymic" placeholder="Отчество">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="number" placeholder="Номер телефона">
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
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Отчество</th>
        <th scope="col">Номер телефона</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
   <@p.pager url page />
<#list page.content as message>
    <tbody>
    <tr>
        <th scope="row">${message.id}</th>
        <td>${message.name}</td>
        <td>${message.surname}</td>
        <td>${message.patronymic}</td>
        <td>${message.number}</td>
<td><a class="btn btn-primary mb-3"  data-toggle="collapse" href="#collapseExample${message.id}" role="button" aria-expanded="false" aria-controls="collapseExample${message.id}">
    Редактировать
</a>
    <div class="collapse" id="collapseExample${message.id}">
        <div class="form-group mt-3">
            <form method="post" action="/${message.id}" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="hidden" class="form-control" name="id" value="${message.id}" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="name" value="${message.name}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="surname" value="${message.surname}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="patronymic" value="${message.patronymic}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="number" value="${message.number}">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div></td>
        <td><form method="post" action="/greeting/${message.id}" enctype="multipart/form-data">
            <button type="submit"  class="btn btn-primary">Удалить</button></form></td>

    </tr>
    </tbody>
</#list>
</table>
<@p.pager url page />
