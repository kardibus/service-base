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
                <input type="text" class="form-control" name="date_Open" placeholder="Поступление в ремонт" id="dateOpen">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="date_Close" placeholder="Дата окончания ремонта" id="dateClose">
            </div>
            <div class="form-group" >
                <input type="text" class="form-control" name="model_id" placeholder="Модел" id="modeldata1">
            </div>
            <div class="form-group" >
                <input type="text" class="form-control" name="users_id" placeholder="Клиент" id="userdata1">
            </div>
            <div class="form-group" >
                <input type="text" class="form-control" name="brand_id" placeholder="Бренд" id="branddata1">
            </div>

            <div class="form-group">
                <select class="custom-select" id="inputGroupSelect01" onchange="U()">
                    <option selected>Выберите владельца</option>
                    <#list messageUsers as messagesUser>
                        <option value="${messagesUser.id}">${messagesUser.surname}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <select class="custom-select" id="inputGroupSelect02" onchange="M()">
                    <option selected>Выберите владельца</option>
                    <#list messageModel as messagesModel>
                        <option value="${messagesModel.id}">${messagesModel.model}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <select class="custom-select" id="inputGroupSelect03" onchange="B()">
                    <option selected>Выберите владельца</option>
                    <#list messageBrand as messagesBrand>
                        <option value="${messagesBrand.id}">${messagesBrand.brand}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="statusOrder" placeholder="Статус заказа" id="status">
            </div>
            <div class="form-group">
                <select class="custom-select" id="inputGroupSelect04" onchange="C()">
                    <option selected>Выберите статус заказа</option>
                        <option value="Готов">Готов</option>
                        <option value="Поступил в ремонт">Поступил в ремонт</option>
                        <option value="Повтор">Повтор</option>
                </select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>