//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下啦选放入的标签id
//参数3: 需要回显时,选中哪个option
//参数4: 生成下拉选时,select标签的name属性值
function loadItemName(typeCode, positionId, selectId, selectName) {
    // 创建select对象，将name属性指定
    var $select = $("<select name="+selectName+"></select>");
    // 添加提示首选项
    $select.append($("<option value='' >---请选择---</option>"));
    $.post("${pageContext.request.contextPath}/BaseDictAction", {"typeCode":typeCode},
        function (data) {
            $.each(data, function (i, value) {
                var $option = $("<option value='"+value['dict_id']+"'>"+value['dict_item_name']+"</option>");
                if (value['dict_id'] == selectId) {
                    $option.attr("selected", "selected");
                }
                $select.append($option);

            });
        },
        "json"
    );

    // 将组装好的select对象放入页面指定位置
    $("#" + positionId).append($select);
}