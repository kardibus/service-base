<#macro pager url page>
   <#if page.getTotalPages() gt 7>
   <#assign
   totalPages=page.getTotalPages()
   pagenumber=page.getNumber()+1
   head=(pagenumber>4)?then([1,-1],[1,2,3])
   tail=(pagenumber<totalPages-3)?then([-1,totalPages],[totalPages-2,totalPages-1,totalPages])
   bodyBefor=(pagenumber>4&&pagenumber<totalPages-1)?then([pagenumber-2,pagenumber-1],[])
   bodyAfter=(pagenumber>2&&pagenumber<totalPages-3)?then([pagenumber+1,pagenumber+2],[])

   body=head+bodyBefor+(pagenumber>3&&pagenumber<totalPages-2)?then([pagenumber],[])+bodyAfter+tail
   >
   <#else>
<#assign body=1..page.getTotalPages()>
   </#if>
    <div>
        <ul class="pagination">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Страницы</a>
        </li>

            <#list body as p>
                <#if (p-1)==page.getNumber()>
            <li class="page-item active">
                <a class="page-link" href="#" tabindex="-1">${p}</a>
            </li>
                    <#elseif p==-1>
                        <li class="page-item disable">
                            <a class="page-link" href="#" tabindex="-1">...</a>
                        </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="?page=${p-1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                    </li>
                </#if>
            </#list>

        </ul>
        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Количество строк</a>
            </li>

            <#list [5,10,25,50] as c>
                <#if c==page.getSize()>
                    <li class="page-item active">
                        <a class="page-link" href="#" tabindex="-1">${c}</a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a>
                    </li>
                </#if>
            </#list>

        </ul>

    </div>
</#macro>