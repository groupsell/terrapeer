/**
 * SchemaShort.java
 *
 * This file was generated by XMLSPY 5 Enterprise Edition.
 *
 * YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
 * OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.
 *
 * Refer to the XMLSPY Documentation for further details.
 * http://www.altova.com/xmlspy
 */

package terrapeer.net.xml.types;

public class SchemaShort implements SchemaType {
	protected short value;

	public SchemaShort(int newvalue) {
		value = (short)newvalue;
	}

	public SchemaShort(String newvalue) {
		value = Short.parseShort(newvalue);
	}

	public short getValue() {
		return value;
	}

	public void setValue(int newvalue) {
		value = (short)newvalue;
	}

	public void setValue(String newvalue) {
		value = Short.parseShort(newvalue);
	}

	public int hashCode() {
		return value;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof SchemaShort))
			return false;
		return value == ((SchemaShort)obj).value;
	}

	public Object clone() {
		return new SchemaShort(value);
	}

	public String toString() {
		return Short.toString(value);
	}

	public String asString() {
		return toString();
	}

	public int compareTo(Object obj) {
		return compareTo((SchemaShort)obj);
	}

	public int compareTo(SchemaShort obj) {
		return new Short(value).compareTo(new Short(obj.value));
	}
}