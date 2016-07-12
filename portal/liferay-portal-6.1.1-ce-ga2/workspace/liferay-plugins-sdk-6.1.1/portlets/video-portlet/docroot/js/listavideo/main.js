function abrir(URL) {

			var width = 480;
			var height = 299;

			var left = 99;
			var top = 99;

			window
					.open(
							URL,
							'janela',
							'width='
									+ width
									+ ', height='
									+ height
									+ ', top='
									+ top
									+ ', left='
									+ left
									+ ', scrollbars=yes, status=no, toolbar=no, location=no, directories=no, menubar=no, resizable=no, fullscreen=no');

		}