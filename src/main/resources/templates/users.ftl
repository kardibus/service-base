<#include "parts/head.ftl">

<a class="btn btn-primary mt-3 mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить клиента
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="/addUsers" enctype="multipart/form-data">
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
                <input type="text" class="form-control" name="numberOne" placeholder="номер 1">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="numberTwo" placeholder="номер 2">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="numberThree" placeholder="номер 3">
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
        <th scope="col">Номер 1</th>
        <th scope="col">Номер 2</th>
        <th scope="col">Номер 3</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

    <#list message as messages>

        <tbody>
        <tr>
            <td>${messages.id}</td>
            <td>${messages.name}</td>
            <td>${messages.surname}</td>
            <td>${messages.patronymic}</td>
            <td>${messages.numberOne}</td>
            <td>${messages.numberTwo}</td>
            <td>${messages.numberThree}</td>
            <td><a class="btn btn-primary mb-3"  data-toggle="collapse" href="#collapseExample${messages.id}" role="button" aria-expanded="false" aria-controls="collapseExample${messages.id}">
                    Редактировать
                </a>
                <div class="collapse" id="collapseExample${messages.id}">
                    <div class="form-group mt-3">
                        <form method="post" action="/updateUsers/${messages.id}" enctype="multipart/form-data">
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" value="${messages.name}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="surname" value="${messages.surname}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="patronymic" value="${messages.patronymic}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="numberOne" value="${messages.numberOne}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="numberTwo" value="${messages.numberTwo}">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="numberThree" value="${messages.numberThree}">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">Сохранить</button>
                            </div>
                        </form>
                    </div>
                </div></td>
            <td><form method="post" action="/deleteUsers/${messages.id}" enctype="multipart/form-data">
                    <button type="submit"  class="btn btn-primary">Удалить</button></form></td>

        </tr>
        </tbody>

    </#list>

</table>

<#include "parts/basement.ftl">