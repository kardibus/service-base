<#include "parts/common.ftl">
<#import "parts/pager.ftl" as p>

<form method="post" action="/searchorder">
    <div class="input-group mb-3">
        <div class="input-group-prepend ">
            <button type="submit" id="button-addon1" class="btn btn-outline-secondary" >Найти</button>
        </div>
        <input type="text" name="filter" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
    </div>
    <div class="custom-control custom-radio custom-control-inline mb-3">
        <input type="radio" id="customRadioInline2" name="radionumber" class="custom-control-input">
        <label class="custom-control-label" for="customRadioInline2">по номеру телефона</label>
    </div>
</form>

<a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить клиента
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="/orderedit" enctype="multipart/form-data">
            <div class="form-group">
                <input type="hidden" class="form-control" name="id" placeholder="№" />
            </div>

            <div class="form-group" >
                <input type="hidden" class="form-control" name="author" placeholder="Владелец" id="usereditedata">
            </div>

            <div class="form-group">
            <select class="custom-select" id="inputGroupSelect01" onchange="f()">
                <option selected>Выберите владельца</option>
              <#list pageUsers.content as messag>
                <option value="${messag.id}">${messag.id} ${messag.surname} ${messag.name} ${messag.patronymic} ${messag.number}</option>
              </#list>
            </select>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="date_open" placeholder="Дата приема">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="date_close" placeholder="Дата выдачи">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="description" placeholder="Описание">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="status" placeholder="Статус">
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
        <th scope="col">Владелец</th>
        <th scope="col">Дата приема</th>
        <th scope="col">Дата выдачи</th>
        <th scope="col">Описание</th>
        <th scope="col">Статус</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
   <@p.pager url page />
<#list page.content as message>
    <tbody>
    <tr>
        <th scope="row">${message.id}</th>
        <td>${message.author.id}</td>
        <td>${message.date_open}</td>
        <td>${message.date_close}</td>
        <td>${message.description}</td>
        <td>${message.status}</td>
<td><a class="btn btn-primary mb-3"  data-toggle="collapse" href="#collapseExample${message.id}" role="button" aria-expanded="false" aria-controls="collapseExample${message.id}">
    Редактировать
</a>
    <div class="collapse" id="collapseExample${message.id}">
        <div class="form-group mt-3">
            <form method="post" action="/order/${message.id}" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="hidden" class="form-control" name="id" value="${message.id}" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="author" value="${message.author.id}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="date_open" value="${message.date_open}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="date_close" value="${message.date_close}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" value="${message.description}">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="status" value="${message.status}">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Сохранить</button>
                </div>
            </form>
        </div>
    </div></td>
        <td><form method="post" action="/orderedit/${message.id}" enctype="multipart/form-data">
            <button type="submit"  class="btn btn-primary">Удалить</button></form></td>

    </tr>
    </tbody>
</#list>
</table>
<@p.pager url page />