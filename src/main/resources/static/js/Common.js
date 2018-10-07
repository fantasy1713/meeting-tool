Common = {
	fillTemplate:function (mytemplate, data, location) {
		if(typeof(data.projects)!="undefined"){
			data.projects.sort(function(a,b){
				if(parseInt(a.projectId) == parseInt(b.projectId))
					return parseInt(a.subProjectId)-parseInt(b.subProjectId)
				return parseInt(a.projectId)-parseInt(b.projectId);
			});
			data.projects = this.sortByTeamStatus(this.groupByProject(data.projects));
		}
			
            var html = template(mytemplate, data);
            $(location).html(html);
            $('[data-toggle="tooltip"]').tooltip({position: { my: "left+15 center", at: "right center" }});
        },
    appendTemplate:function(mytemplate, data, location){
    	var html = template(mytemplate, data);
        $(location).append(html);
    }
}