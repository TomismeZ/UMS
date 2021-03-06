$(function(){
	/**
	**manage.jsp begin
	*/
	var $table = $rightContent.find("table");
	//同一行上删除当前选中账户
	var $operator = $table.find("tbody").find("tr");
	/**
	 * 实现全选功能
	 */
	$table.find("thead").find("th:first").on("click", function() {
		// 获取列表中所有的checkbox
		var checkboxItems = $table.find("input[name='checkbox']");

		// 获取列表中选中的checkBox
		var checkedboxItems = $table.find("input[name='checkbox']:checked");

		// 如果两个列表的数量相等，表示所有的checkbox都被选中，则反选
		// 反之，则全选
		var isChecked = checkboxItems.length === checkedboxItems.length;

		// 去两个列表长度判断的反值
		checkboxItems.prop("checked", !isChecked);
	});
	/**
	 * 选中一行就可以选中复选框，除了第一个和最后一个td
	 */
	$table.find("tbody").find("tr td:not(:first-child,:last-child)").on(
			"click", function() {
				var $this = $(this).parent();
				//高亮处理
				$table.find("tbody").find("tr").removeClass("active");
				$this.addClass("active");
				var nowItem = $this.find("input[name='checkbox']");
				// 获取当前行CheckBox的状态值
				var isChecked = nowItem.prop("checked");

				// 最新的状态值只需要与当前状态值相反即可
				nowItem.prop("checked", !isChecked);
			});

	/**
	 * 实现添加账户
	 */
	$rightContent.find(".header").find("button:first").on("click", function() {
		/*$rightContent.load(manageRef);*/
		
		$.ajax({
		        type: "POST",
		        url:addPrivilege,
		        error: function(request) {
		        	toastr.error("Connection error");
		        },
		        success: function(data) {
		        	if(data.message=='success'){
		        		$rightContent.load(manageRef)
		        	}else{
		        		toastr.info("权限不足");
		        	}
		        	
		        }
		    });
	});
	/**
	 * 根据复选框选中的状态删除用户
	 */
	$rightContent.find(".header").find("button:last").on("click", function() {
		
		 toastr.options = {   
	                positionClass: "toast-top-center"              
	            };  
		var ckbs = $operator.find("input[name='checkbox']:checked");
		
		var arrayId = new Array();
		if (ckbs.size() == 0) {
			toastr.info("要删除指定行，需选中要删除的行！");
			return;
		} else {
			if (confirm("确定要删除选中项？")) {

				/* ckbs.parent().parent().hide(); */
				ckbs.each(function(i) {
					arrayId[i] = $(this).data("id");
				
					/*$rightContent.load(deleteInfo,{id : arrayId[i],page:currentPage});*/
				});
				
				console.log(arrayId);
				/*$rightContent.load(deleteInfo,{arrayId : arrayId});*/
				/**
				实现异步刷新，
				**/
				
				$.ajax({
				  traditional: true,
			        cache: true,
			        type: "POST",
			        url:deleteInfo,
			        data:{
			        	arrayId : arrayId
			        },
			        async: true,
			        error: function(request) {
			        	toastr.error("Connection error");
			        },
			        success: function(data) {
			        	if(data.message=='error'){
			        		toastr.warning("该对象有用户在使用，你不能删除掉！");
			        	}else if(data.message=='success'){
			        		$rightContent.load(findAllInfo,function(){
			        			toastr.success("删除成功");
			        		});
			        	}else{
			        		toastr.info("权限不足！")
			        	}
			        	
			        }
			    });

			}

		}
	});
	
	//同一行上删除当前选中账户
/*	$table.find("tbody").find("tr:odd").css("background-color", "#F0F0F0");*/
	$operator.find("a:last").on("click", function(e) {
		
		
		var $this = $(this);
		
		//阻止a标签原有的默认事件
		e.preventDefault();

		var ckbs = $operator.find("input[name='checkbox']:checked");
		var id=$this.data("id");
		var trId = ckbs.parent().parent().data("id");
		console.log("id:" + id);
		console.log("trId:" + trId);
		//得到a标签href属性的值
		var pageRef = $this.prop("href");
		console.log(pageRef);
		console.log("ckbsValue:" + ckbs.val());
		if (confirm("确定要删除选中项？")) {
			/*$rightContent.load(pageRef,{id : id,page:currentPage});*/
			/**
			实现异步刷新，
			**/
			$.ajax({
		        cache: true,
		        type: "POST",
		        url:pageRef,
		        data:{
		        	id : id
		        },
		        async: true,
		        error: function(request) {
		            alert("Connection error");
		        },
		        success: function(data) {
		        	if(data.message=='error'){
		        		toastr.warning("该对象有用户在使用，你不能删除掉！");
		        	}else if(data.message=='success'){
		        		console.log(allRows % 5 == 1);
		        		if(allRows % 5 == 1){
		        			--currentPage;
		        		}
		        		$rightContent.load(findAllInfo,{page:currentPage},function(){
		        			toastr.success("删除成功");
		        		});
		        	}else{
		        		toastr.info("权限不足！")
		        	}
		        	
		        }
		    });
		}
	});
	

	

	//编辑该账户
	//同一行上编辑当前选中账户
	
	$operator.find("a:first").on("click", function(e) {
		var $this = $(this);
		
		//阻止a标签原有的默认事件
		e.preventDefault();

		var ckbs = $operator.find("input[name='checkbox']:checked");
		var id=$this.data("id");
		var trId = ckbs.parent().parent().data("id");
		console.log("id:" + id);
		console.log("trId:" + trId);
		//得到a标签href属性的值
		var pageRef = $this.prop("href");
		console.log(pageRef);
		console.log("ckbsValue:" + ckbs.val());
		
/*		$rightContent.load(pageRef, {
			//左边是Action里的值，右边是js定义的变量
			id: id
		});*/
		$.ajax({
	        type: "POST",
	        url:pageRef,
	        data:{
	        	id: id
	        },
	        error: function(request) {
	        	toastr.error("Connection error");
	        },
	        success: function(data) {
	        	if(data.message=='success'){
	        		$rightContent.load(manageRef,{id: id});
	        	}else{
	        		toastr.info("权限不足！")
	        	}
	        	
	        }
	    });
	});
	/**
	实现分页（超链接跳转功能）模块
	**/
	$mangeClass.find(".footer").find("a").on(
			"click", function(e) {
				
				var $this = $(this);
				var mythis=$(this);
				
				var page = $this.data("page");

				console.log(page);
				//阻止a标签原有的默认事件
				e.preventDefault();
				//得到a标签href属性的值
				/* var pageRef = $this.prop("href"); */
				var pageRef=findAllInfo;
				$rightContent.load(pageRef, {
					page : page
				});

			});
	
	/**
	**XXmanage.jsp end
	*/

	
});