<script type="text/javascript">

	function ws_basic_linear(options, images) {
		var J = jQuery.noConflict();
		var curIdx = 0;
		var movingDiv = J("<div></div>").css({
			position : "absolute",
			display : "none",
			'z-index' : 2,
			width : options.width * 2 + "px",
			height : options.height + "px"
		}).appendTo(J(images[0]).parent().parent());
		images.each(function(Index) {
			J(this).css({
				'z-index' : 0
			});
			if (!Index) {
				J(this).show();
			} else {
				J(this).hide();
			}
		});
		this.init = function() {
		};
		this.go = function(new_index) {
			movingDiv.stop(1, 1);
			var dir = (new_index - curIdx + 1) % images.length ? "left"
					: "right";
			J(images[curIdx]).clone().css({
				position : "absolute",
				left : "auto",
				right : "auto",
				top : 0
			}).appendTo(movingDiv).css(dir, 0);
			J(images[new_index]).clone().css({
				position : "absolute",
				left : "auto",
				right : "auto",
				top : 0
			}).appendTo(movingDiv).css(dir, options.width + "px").show();
			movingDiv.css({
				left : "auto",
				right : "auto",
				top : 0
			}).css(dir, 0).show();
			J(images[curIdx]).hide();
			var an = {};
			an[dir] = -options.width + "px";
			movingDiv.animate(an, options.duration, "easeInOutExpo",
					function() {
						J(images[new_index]).show();
						J(this).hide().html("");
					});
			curIdx = new_index;
			return true;
		};
	}// -----------------------------------------------------------------------------------

	jQuery.fn.wowSlider = function(options) {
		var Jthis = this;
		var J = jQuery;
		options = J.extend({
			effect : function(options) {
				var images;
				this.init = function(aCont) {
					images = aCont.find("img");
					images.each(function(Index) {
						if (!Index) {
							J(this).show();
						} else {
							J(this).hide();
						}
					});
				};
				this.go = function(new_index, curIdx) {
					J(images.get(new_index)).fadeIn(options.duration);
					J(images.get(curIdx)).fadeOut(options.duration);
					return true;
				};
			},
			prev : "",
			next : "",
			duration : 1000,
			delay : 2000,
			outWidth : 960,
			outHeight : 360,
			width : 960,
			height : 360,
			caption : true,
			controls : true,
			autoPlay : true,
			bullets : true,
			onStep : function() {
			},
			stopOnHover : 0
		}, options);
		options.loop = options.loop || Number.MAX_VALUE;
		var JElements = Jthis.find(".ws_images A");
		var images = JElements.find("IMG");
		JElements.each(function(index) {
			var inner = J(this).html() || "";
			var pos = inner.indexOf(">", inner);
			if (pos >= 0) {
				J(this).data("descr", inner.substr(pos + 1));
				if (pos < inner.length - 1) {
					J(this).html(inner.substr(0, pos + 1));
				}
			}
			J(this).css({
				'font-size' : 0
			});
		});
		var elementsCount = JElements.length;
		var frame = J("A.ws_frame", Jthis).get(0);
		var curIdx = 0;
		function go(index) {
			index = (index % elementsCount + elementsCount) % elementsCount;
			if (curIdx == index) {
				return;
			}
			var current = effect.go(index, curIdx);
			if (!current) {
				return;
			}
			if (typeof current != "object") {
				current = JElements[index];
			}
			curIdx = index;
			go2(index);
			if (options.caption) {
				setTitle(current);
			}
			options.onStep(curIdx);
		}
		var startX, startY, isMoving = 0;
		var _this = Jthis.get(0);
		if (_this.addEventListener) {
			_this.addEventListener("touchmove", function(e) {
				if (isMoving) {
					var dx = startX - e.touches[0].pageX;
					var dy = startY - e.touches[0].pageY;
					if (Math.abs(dx) > 20 || Math.abs(dy) > 20) {
						startX = startY = isMoving = 0;
						forceGo(e, curIdx + (dx + dy > 0 ? -1 : 1));
					}
				}
			}, false);
			_this.addEventListener("touchstart", function(e) {
				if (e.touches.length == 1) {
					startX = e.touches[0].pageX;
					startY = e.touches[0].pageY;
					isMoving = 1;
				} else {
					isMoving = 0;
				}
			}, false);
			_this.addEventListener("touchend", function(e) {
				isMoving = 0;
			}, false);
		}
		function go2(index) {
			if (options.bullets) {
				setBullet(index);
			}
			if (frame) {
				frame.setAttribute("href", JElements.get(index).href);
			}
		}
		var autoPlayTimer;
		function restartPlay() {
			stopPlay();
			if (options.autoPlay) {
				autoPlayTimer = setTimeout(function() {
					go(curIdx < elementsCount - 1 ? curIdx + 1 : 0);
					if (!curIdx && !--options.loop) {
						options.autoPlay = 0;
					}
					restartPlay();
				}, options.delay + options.duration);
			}
		}
		function stopPlay() {
			if (autoPlayTimer) {
				clearTimeout(autoPlayTimer);
			}
			autoPlayTimer = null;
		}
		function forceGo(event, index) {
			stopPlay();
			event.preventDefault();
			go(index);
			restartPlay();
		}
		JElements.find("IMG").css("position", "absolute");
		if (typeof options.effect == "string") {
			options.effect = window["ws_" + options.effect];
		}
		var effect = new options.effect(options, images);
		effect.init(J(".ws_images", Jthis));
		JElements.find("IMG").css("visibility", "visible");
		var ic = c = J(".ws_images", Jthis);
		var t = "";
		c = t ? J("<div></div>") : 0;
		if (c) {
			c.css({
				position : "absolute",
				right : "2px",
				bottom : "2px",
				padding : "0 0 0 0"
			});
			ic.append(c);
		}
		if (c && document.all) {
			var f = J("<iframe src=\"javascript:false\"></iframe>");
			f.css({
				position : "absolute",
				left : 0,
				top : 0,
				width : "100%",
				height : "100%",
				filter : "alpha(opacity=0)"
			});
			f.attr({
				scrolling : "no",
				framespacing : 0,
				border : 0,
				frameBorder : "no"
			});
			c.append(f);
		}
		var d = c ? J(document.createElement("A")) : c;
		if (d) {
			d.css({
				position : "relative",
				display : "block",
				'background-color' : "#E4EFEB",
				color : "#837F80",
				'font-family' : "Lucida Grande,sans-serif",
				'font-size' : "11px",
				'font-weight' : "normal",
				'font-style' : "normal",
				'-moz-border-radius' : "5px",
				'border-radius' : "5px",
				padding : "1px 5px",
				width : "auto",
				height : "auto",
				margin : "0 0 0 0",
				outline : "none"
			});
			d.attr({
				href : "ht" + "tp://" + t.toLowerCase()
			});
			d.html(t);
			d.bind("contextmenu", function(eventObject) {
				return false;
			});
			c.append(d);
		}
		if (options.controls) {
			var Jnext_photo = J("<a href=\"#\" class=\"ws_next\">"
					+ options.next + "</a>");
			var Jprev_photo = J("<a href=\"#\" class=\"ws_prev\">"
					+ options.prev + "</a>");
			Jthis.append(Jnext_photo);
			Jthis.append(Jprev_photo);
			Jnext_photo.bind("click", function(e) {
				forceGo(e, curIdx + 1);
			});
			Jprev_photo.bind("click", function(e) {
				forceGo(e, curIdx - 1);
			});
		}
		function initBullets() {
			var Jbullets_cont = Jthis.find(".ws_bullets>div");
			var Jbullets = J("a", Jbullets_cont);
			Jbullets.click(function(e) {
				forceGo(e, J(e.target).index());
			});
			var Jthumbs = Jbullets.find("IMG");
			if (Jthumbs.length) {
				var mainFrame = J("<div class=\"ws_bulframe\"/>").appendTo(
						Jbullets_cont);
				var imgContainer = J("<div/>").css({
					width : Jthumbs.length + 1 + "00%"
				}).appendTo(J("<div/>").appendTo(mainFrame));
				Jthumbs.appendTo(imgContainer);
				J("<span/>").appendTo(mainFrame);
				var curIndex = -1;
				function moveTooltip(index) {
					if (index < 0) {
						index = 0;
					}
					J(Jbullets.get(curIndex)).removeClass("ws_overbull");
					J(Jbullets.get(index)).addClass("ws_overbull");
					mainFrame.show();
					var mainCSS = {
						left : Jbullets.get(index).offsetLeft
								- mainFrame.width() / 2
					};
					var contCSS = {
						left : -Jthumbs.get(index).offsetLeft
					};
					if (curIndex < 0) {
						mainFrame.css(mainCSS);
						imgContainer.css(contCSS);
					} else {
						if (!document.all) {
							mainCSS.opacity = 1;
						}
						mainFrame.stop().animate(mainCSS, "fast");
						imgContainer.stop().animate(contCSS, "fast");
					}
					curIndex = index;
				}
				Jbullets.hover(function() {
					moveTooltip(J(this).index());
				});
				var hideTime;
				Jbullets_cont.hover(function() {
					if (hideTime) {
						clearTimeout(hideTime);
						hideTime = 0;
					}
					moveTooltip(curIndex);
				}, function() {
					Jbullets.removeClass("ws_overbull");
					if (document.all) {
						if (!hideTime) {
							hideTime = setTimeout(function() {
								mainFrame.hide();
								hideTime = 0;
							}, 400);
						}
					} else {
						mainFrame.stop().animate({
							opacity : 0
						}, {
							duration : "fast",
							complete : function() {
								mainFrame.hide();
							}
						});
					}
				});
				Jbullets_cont.click(function(e) {
					forceGo(e, J(e.target).index());
				});
			}
		}
		function setBullet(new_index) {
			J(".ws_bullets A", Jthis).each(function(index) {
				if (index == new_index) {
					J(this).addClass("ws_selbull");
				} else {
					J(this).removeClass("ws_selbull");
				}
			});
		}
		if (options.caption) {
			Jcaption = J("<div class='ws-title' style='display:none'></div>");
			Jthis.append(Jcaption);
			Jcaption.bind("mouseover", function(e) {
				stopPlay();
			});
			Jcaption.bind("mouseout", function(e) {
				restartPlay();
			});
		}
		function setTitle(A) {
			var title = J("img", A).attr("title");
			var descr = J(A).data("descr");
			var JTitle = J(".ws-title", Jthis);
			JTitle.hide();
			if (title || descr) {
				JTitle.html((title ? "<span>" + title + "</span>" : "")
						+ (descr ? "<div>" + descr + "</div>" : ""));
				showWithSlide(JTitle, {
					direction : "left",
					easing : "easeInOutExpo",
					complete : function() {
						if (J.browser.msie) {
							JTitle.get(0).style.removeAttribute("filter");
						}
					},
					duration : 1000
				});
			}
		}
		if (options.bullets) {
			initBullets();
		}
		go2(0);
		if (options.caption) {
			setTitle(JElements[0]);
		}
		if (options.stopOnHover) {
			this.bind("mouseover", function(e) {
				stopPlay();
			});
			this.bind("mouseout", function(e) {
				restartPlay();
			});
		}
		restartPlay();
		function showWithSlide(element, options) {
			var J = jQuery;
			element.stop(true, true);
			var bkp_prop = {};
			var props = [ "position", "top", "bottom", "left", "right" ];
			for ( var i = 0; i < props.length; i++) {
				bkp_prop[props[i]] = element[0].style[props[i]];
			}
			element.show();
			var wrap_props = {
				width : element.outerWidth(true),
				height : element.outerHeight(true),
				'float' : element.css("float"),
				overflow : "hidden",
				opacity : 0
			}, wrapper = J("<div></div>").css({
				fontSize : "100%",
				background : "transparent",
				border : "none",
				margin : 0,
				padding : 0
			});
			element.wrap(wrapper);
			wrapper = element.parent();
			if (element.css("position") == "static") {
				wrapper.css({
					position : "relative"
				});
				element.css({
					position : "relative"
				});
			} else {
				J.extend(wrap_props, {
					position : element.css("position"),
					zIndex : element.css("z-index")
				});
				J.each([ "top", "left", "bottom", "right" ], function(i, pos) {
					wrap_props[pos] = element.css(pos);
					if (isNaN(parseInt(wrap_props[pos], 10))) {
						wrap_props[pos] = "auto";
					}
				});
				element.css({
					position : "relative",
					top : 0,
					left : 0,
					right : "auto",
					bottom : "auto"
				});
			}
			wrapper.css(wrap_props).show();
			var direction = options.direction || "left";
			var ref = direction == "up" || direction == "down" ? "top" : "left";
			var motion = direction == "up" || direction == "left" ? "pos"
					: "neg";
			var distance = options.distance
					|| (ref == "top" ? element.outerHeight({
						margin : true
					}) : element.outerWidth({
						margin : true
					}));
			element.css(ref, motion == "pos" ? isNaN(distance) ? "-" + distance
					: -distance : distance);
			var animation = {};
			animation[ref] = (motion == "pos" ? "+=" : "-=") + distance;
			wrapper.animate({
				opacity : 1
			}, {
				duration : options.duration,
				easing : options.easing
			});
			element.animate(animation, {
				queue : false,
				duration : options.duration,
				easing : options.easing,
				complete : function() {
					for ( var p in bkp_prop) {
						element[0].style[p] = bkp_prop[p];
					}
					element.parent().replaceWith(element);
					if (options.complete) {
						options.complete();
					}
				}
			});
		}
		return this;
	};
	jQuery.extend(jQuery.easing, {
		easeInOutExpo : function(x, t, b, c, d) {
			if (t == 0) {
				return b;
			}
			if (t == d) {
				return b + c;
			}
			if ((t /= d / 2) < 1) {
				return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
			}
			return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b;
		}
	});// -----------------------------------------------------------------------------------

	jQuery("#${portletId}").wowSlider({
		effect : "basic_linear",
		prev : "",
		next : "",
		duration : 100 * ${duracao},
		delay : 1000 * ${intervalo},
		outWidth : ${widthBanner},
		outHeight : ${heightBanner},
		width : ${widthBanner},
		height : ${heightBanner},
		autoPlay : true,
		stopOnHover : true,
		loop : false,
		bullets : true,
		caption : ${exibirTitulo},
		controls : ${exibirControles}
	});




</script>