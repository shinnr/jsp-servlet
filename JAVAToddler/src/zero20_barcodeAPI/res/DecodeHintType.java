package zero20_barcodeAPI.res;

import java.util.List;

import com.google.zxing.ResultPointCallback;

public enum DecodeHintType {
	 /**
	   * Unspecified, application-specific hint. Maps to an unspecified {@link Object}.
	   */
	 OTHER(Object.class),

	  /**
	   * Image is a pure monochrome image of a barcode. Doesn't matter what it maps to;
	   * use {@link Boolean#TRUE}.
	   */
	  PURE_BARCODE(Void.class),

	  /**
	   * Image is known to be of one of a few possible formats.
	   * Maps to a {@link List} of {@link BarcodeFormat}s.
	   */
	  POSSIBLE_FORMATS(List.class),

	  /**
	   * Spend more time to try to find a barcode; optimize for accuracy, not speed.
	   * Doesn't matter what it maps to; use {@link Boolean#TRUE}.
	   */
	  TRY_HARDER(Void.class),

	  /**
	   * Specifies what character encoding to use when decoding, where applicable (type String)
	   */
	  CHARACTER_SET(String.class),

	  /**
	   * Allowed lengths of encoded data -- reject anything else. Maps to an {@code int[]}.
	   */
	  ALLOWED_LENGTHS(int[].class),

	  /**
	   * Assume Code 39 codes employ a check digit. Doesn't matter what it maps to;
	   * use {@link Boolean#TRUE}.
	   */
	  ASSUME_CODE_39_CHECK_DIGIT(Void.class),

	  /**
	   * Assume the barcode is being processed as a GS1 barcode, and modify behavior as needed.
	   * For example this affects FNC1 handling for Code 128 (aka GS1-128). Doesn't matter what it maps to;
	   * use {@link Boolean#TRUE}.
	   */
	  ASSUME_GS1(Void.class),

	  /**
	   * The caller needs to be notified via callback when a possible {@link ResultPoint}
	   * is found. Maps to a {@link ResultPointCallback}.
	   */
	  NEED_RESULT_POINT_CALLBACK(ResultPointCallback.class),

	  // End of enumeration values.
	  ;

	  /**
	   * Data type the hint is expecting.
	   * Among the possible values the {@link Void} stands out as being used for
	   * hints that do not expect a value to be supplied (flag hints). Such hints
	   * will possibly have their value ignored, or replaced by a
	   * {@link Boolean#TRUE}. Hint suppliers should probably use
	   * {@link Boolean#TRUE} as directed by the actual hint documentation.
	   */
	  private final Class<?> valueType;

	  DecodeHintType(Class<?> valueType) {
	    this.valueType = valueType;
	  }
	  
	  public Class<?> getValueType() {
	    return valueType;
	  }

}
