$(document).ready(
		function() {

			$('#nvinsc').change(
					function() {
						
						var y = $("#nvinsc option:selected").val();
						$('#specinsc').find('option').remove();
						switch (y) {
						case 'licence1': {
							$('#specinsc').append(
									$("<option></option>").attr("value", 'MI').text("MI"));
						};break;
						case 'master1': {
							$('#specinsc').append($("<option></option>").attr("value", 'GL').text("GL"));
							$('#specinsc').append($("<option></option>").attr("value", 'SITW').text("SITW"));
							$('#specinsc').append($("<option></option>").attr("value", 'RSD').text("RSD"));
							$('#specinsc').append($("<option></option>").attr("value", 'STIC').text("STIC"));

						}
							;
							break;
							
						}

					});
			$('#nvreinsc').change(
					function() {
						

						var y = $("#nvreinsc option:selected").val();
						$('#specreinsc').find('option').remove();
						switch (y) {
						case 'licence1': {
							$('#specreinsc').append(
									$("<option></option>").attr("value", 'MI').text("MI"));
						};break;
						case 'licence2': {
							$('#specreinsc').append(
									$("<option></option>").attr("value", 'MI').text("MI"));
						};break;
						case 'licence3': {
							$('#specreinsc').append($("<option></option>").attr("value", 'GL').text("GL"));
							$('#specreinsc').append($("<option></option>").attr("value", 'SI').text("SI"));
							$('#specreinsc').append($("<option></option>").attr("value", 'SCI').text("SCI"));
							$('#specreinsc').append($("<option></option>").attr("value", 'TI').text("TI"));

						};break;
						case 'master1': {
							$('#specreinsc').append($("<option></option>").attr("value", 'GL').text("GL"));
							$('#specreinsc').append($("<option></option>").attr("value", 'SITW').text("SITW"));
							$('#specreinsc').append($("<option></option>").attr("value", 'RSD').text("RSD"));
							$('#specreinsc').append($("<option></option>").attr("value", 'STIC').text("STIC"));

						};break;
						case 'master2': {
							$('#specreinsc').append($("<option></option>").attr("value", 'GL').text("GL"));
							$('#specreinsc').append($("<option></option>").attr("value", 'SITW').text("SITW"));
							$('#specreinsc').append($("<option></option>").attr("value", 'RSD').text("RSD"));
							$('#specreinsc').append($("<option></option>").attr("value", 'STIC').text("STIC"));

						};break;
							
						}

					});

		});
