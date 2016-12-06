(function($) {
	$.fn.extend( {
		unNumber : function() {
			var me = jQuery(this);

			me.unbind("keypress.justNumber");

			return me;
		},

		justNumber : function() {
			var me = jQuery(this);

			me.bind("keypress.justNumber", function(event) {
				return _justNumbers(this, event);
			});

			return me;
		}
	});

	function _justNumbers(field, event) {
		var keyCode = _getKeyCode(event);

		if (keyCode == 8) {
			return true;
		}

		if (keyCode == 9) {
			return true;
		}

		if (keyCode == 10) {
			return true;
		}

		if (keyCode == 27) {
			return true;
		}

		if ((keyCode > 32) && (keyCode < 41)) {
			return true;
		}

		if ((keyCode == 45) || (keyCode == 46)) {
			return true;
		}

		if ((keyCode > 47) && (keyCode < 58)) {
			return true;
		}

		return false;
	}

	function _getKeyCode(event) {
		return event.keyCode ? event.keyCode : event.which ? event.which
				: event.charCode;
	}
})(jQuery);