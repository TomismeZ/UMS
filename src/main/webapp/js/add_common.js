
$rightContent.find(".button-group").find("button:first").on("click",function(){
		$rightContent.load(findAllInfo);
	});
$rightContent.find(".button-group").find("button:last").on("click",function(){
		var $form=$content.find("form");
		/*$form.on("submit",function(e){
			//阻止原标签原有的默认事件
			 e.preventDefault();
			 //得到form标签action属性的值
	         var pageRef=$(this).prop("action");
	         //JQuery load页面,局部刷新
	         $rightContent.load(pageRef,$form.serialize());
		}).submit();*/
		//异步刷新
		var name=$form.find("input[type='text']").val();
		var description=$form.find("textarea").val();
		if(name.length == 0 || description.length ==0){
			alert("字段不能为空！")
		}else{
			$.ajax({
		        cache: true,
		        type: "POST",
		        url:$form.prop("action"),
		        data:$form.serialize(),// 你的formid
		        async: false,
		        error: function(request) {
		            alert("Connection error");
		        },
		        success: function(data) { 
		        	if(data.message == 'success'){
		        		$rightContent.load(findAllInfo);
		        	}else{
		        		alert("权限不足")
		        	}
		        	
		        }
		    });
		}
		
	});