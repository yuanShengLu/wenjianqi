$(function() {
	$("div[name=createRecruitment]").hide();
	$("div[name=readResumes]").hide();
	
	
	$("img[name=back]").click(function() {
		window.location.href="http://localhost:8080/FinalProject/index.jsp";
	})
	
	$("img[name=createRecruitment]").click(function() {
		$("div[name=readResumes]").hide();
		$("div[name=createRecruitment]").show();
	})
	
	$("img[name=readResumes]").click(function() {
		$("div[name=createRecruitment]").hide();
		$("div[name=readResumes]").show();
	})
	
	$(":submit[name=recConfirm]").click(function() {
		var info = "确认发布招聘信息？";
		if(confirm(info)==true){
			alert("发布成功！")
			$("form[name=createRecruitment]").attr("onsubmit","return true");
		}else{
			$("form[name=createRecruitment]").attr("onsubmit","return false");
		}
	})
	
	
	
	
	
	
	
})