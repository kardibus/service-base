<#include "parts/head.ftl">

<a class="btn btn-primary mt-3 mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Добавить марку
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="/addBrand" enctype="multipart/form-data">
            <div class="form-group">
                <input type="hidden" class="form-control" name="id" placeholder="№" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="brand" placeholder="Марка">
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
        <th scope="col">Марка</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>

<#list message as messages>

    <tbody>
    <tr>
   <td>${messages.id}</td>
    <td>${messages.brand}</td>
        <td><a class="btn btn-primary mb-3"  data-toggle="collapse" href="#collapseExample${messages.id}" role="button" aria-expanded="false" aria-controls="collapseExample${messages.id}">
                Редактировать
            </a>
            <div class="collapse" id="collapseExample${messages.id}">
                <div class="form-group mt-3">
                    <form method="post" action="/updateBrand/${messages.id}" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="text" class="form-control" name="brand" value="${messages.brand}">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Сохранить</button>
                        </div>
                    </form>
                </div>
            </div></td>
        <td><form method="post" action="/deleteBrand/${messages.id}" enctype="multipart/form-data">
                <button type="submit"  class="btn btn-primary">Удалить</button></form></td>

    </tr>
    </tbody>

</#list>

</table>

<#include "parts/basement.ftl">

