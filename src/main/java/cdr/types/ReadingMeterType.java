/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package cdr.types;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ReadingMeterType extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5126639358263182101L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ReadingMeterType\",\"namespace\":\"cdr.types\",\"fields\":[{\"name\":\"meterID\",\"type\":\"int\"},{\"name\":\"reading\",\"type\":\"float\"},{\"name\":\"meterType\",\"type\":\"string\"},{\"name\":\"lastUpdate\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\"}}],\"connect.version\":1,\"connect.name\":\"cdr.types.ReadingMeterType\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<ReadingMeterType> ENCODER =
      new BinaryMessageEncoder<ReadingMeterType>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ReadingMeterType> DECODER =
      new BinaryMessageDecoder<ReadingMeterType>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ReadingMeterType> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ReadingMeterType> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ReadingMeterType> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ReadingMeterType>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ReadingMeterType to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ReadingMeterType from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ReadingMeterType instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ReadingMeterType fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int meterID;
  private float reading;
  private java.lang.CharSequence meterType;
  private java.time.Instant lastUpdate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ReadingMeterType() {}

  /**
   * All-args constructor.
   * @param meterID The new value for meterID
   * @param reading The new value for reading
   * @param meterType The new value for meterType
   * @param lastUpdate The new value for lastUpdate
   */
  public ReadingMeterType(java.lang.Integer meterID, java.lang.Float reading, java.lang.CharSequence meterType, java.time.Instant lastUpdate) {
    this.meterID = meterID;
    this.reading = reading;
    this.meterType = meterType;
    this.lastUpdate = lastUpdate.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return meterID;
    case 1: return reading;
    case 2: return meterType;
    case 3: return lastUpdate;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: meterID = (java.lang.Integer)value$; break;
    case 1: reading = (java.lang.Float)value$; break;
    case 2: meterType = (java.lang.CharSequence)value$; break;
    case 3: lastUpdate = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'meterID' field.
   * @return The value of the 'meterID' field.
   */
  public int getMeterID() {
    return meterID;
  }


  /**
   * Sets the value of the 'meterID' field.
   * @param value the value to set.
   */
  public void setMeterID(int value) {
    this.meterID = value;
  }

  /**
   * Gets the value of the 'reading' field.
   * @return The value of the 'reading' field.
   */
  public float getReading() {
    return reading;
  }


  /**
   * Sets the value of the 'reading' field.
   * @param value the value to set.
   */
  public void setReading(float value) {
    this.reading = value;
  }

  /**
   * Gets the value of the 'meterType' field.
   * @return The value of the 'meterType' field.
   */
  public java.lang.CharSequence getMeterType() {
    return meterType;
  }


  /**
   * Sets the value of the 'meterType' field.
   * @param value the value to set.
   */
  public void setMeterType(java.lang.CharSequence value) {
    this.meterType = value;
  }

  /**
   * Gets the value of the 'lastUpdate' field.
   * @return The value of the 'lastUpdate' field.
   */
  public java.time.Instant getLastUpdate() {
    return lastUpdate;
  }


  /**
   * Sets the value of the 'lastUpdate' field.
   * @param value the value to set.
   */
  public void setLastUpdate(java.time.Instant value) {
    this.lastUpdate = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Creates a new ReadingMeterType RecordBuilder.
   * @return A new ReadingMeterType RecordBuilder
   */
  public static cdr.types.ReadingMeterType.Builder newBuilder() {
    return new cdr.types.ReadingMeterType.Builder();
  }

  /**
   * Creates a new ReadingMeterType RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ReadingMeterType RecordBuilder
   */
  public static cdr.types.ReadingMeterType.Builder newBuilder(cdr.types.ReadingMeterType.Builder other) {
    if (other == null) {
      return new cdr.types.ReadingMeterType.Builder();
    } else {
      return new cdr.types.ReadingMeterType.Builder(other);
    }
  }

  /**
   * Creates a new ReadingMeterType RecordBuilder by copying an existing ReadingMeterType instance.
   * @param other The existing instance to copy.
   * @return A new ReadingMeterType RecordBuilder
   */
  public static cdr.types.ReadingMeterType.Builder newBuilder(cdr.types.ReadingMeterType other) {
    if (other == null) {
      return new cdr.types.ReadingMeterType.Builder();
    } else {
      return new cdr.types.ReadingMeterType.Builder(other);
    }
  }

  /**
   * RecordBuilder for ReadingMeterType instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ReadingMeterType>
    implements org.apache.avro.data.RecordBuilder<ReadingMeterType> {

    private int meterID;
    private float reading;
    private java.lang.CharSequence meterType;
    private java.time.Instant lastUpdate;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(cdr.types.ReadingMeterType.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.meterID)) {
        this.meterID = data().deepCopy(fields()[0].schema(), other.meterID);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.reading)) {
        this.reading = data().deepCopy(fields()[1].schema(), other.reading);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.meterType)) {
        this.meterType = data().deepCopy(fields()[2].schema(), other.meterType);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.lastUpdate)) {
        this.lastUpdate = data().deepCopy(fields()[3].schema(), other.lastUpdate);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing ReadingMeterType instance
     * @param other The existing instance to copy.
     */
    private Builder(cdr.types.ReadingMeterType other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.meterID)) {
        this.meterID = data().deepCopy(fields()[0].schema(), other.meterID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.reading)) {
        this.reading = data().deepCopy(fields()[1].schema(), other.reading);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.meterType)) {
        this.meterType = data().deepCopy(fields()[2].schema(), other.meterType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.lastUpdate)) {
        this.lastUpdate = data().deepCopy(fields()[3].schema(), other.lastUpdate);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'meterID' field.
      * @return The value.
      */
    public int getMeterID() {
      return meterID;
    }


    /**
      * Sets the value of the 'meterID' field.
      * @param value The value of 'meterID'.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder setMeterID(int value) {
      validate(fields()[0], value);
      this.meterID = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'meterID' field has been set.
      * @return True if the 'meterID' field has been set, false otherwise.
      */
    public boolean hasMeterID() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'meterID' field.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder clearMeterID() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'reading' field.
      * @return The value.
      */
    public float getReading() {
      return reading;
    }


    /**
      * Sets the value of the 'reading' field.
      * @param value The value of 'reading'.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder setReading(float value) {
      validate(fields()[1], value);
      this.reading = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'reading' field has been set.
      * @return True if the 'reading' field has been set, false otherwise.
      */
    public boolean hasReading() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'reading' field.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder clearReading() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'meterType' field.
      * @return The value.
      */
    public java.lang.CharSequence getMeterType() {
      return meterType;
    }


    /**
      * Sets the value of the 'meterType' field.
      * @param value The value of 'meterType'.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder setMeterType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.meterType = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'meterType' field has been set.
      * @return True if the 'meterType' field has been set, false otherwise.
      */
    public boolean hasMeterType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'meterType' field.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder clearMeterType() {
      meterType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastUpdate' field.
      * @return The value.
      */
    public java.time.Instant getLastUpdate() {
      return lastUpdate;
    }


    /**
      * Sets the value of the 'lastUpdate' field.
      * @param value The value of 'lastUpdate'.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder setLastUpdate(java.time.Instant value) {
      validate(fields()[3], value);
      this.lastUpdate = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'lastUpdate' field has been set.
      * @return True if the 'lastUpdate' field has been set, false otherwise.
      */
    public boolean hasLastUpdate() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'lastUpdate' field.
      * @return This builder.
      */
    public cdr.types.ReadingMeterType.Builder clearLastUpdate() {
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ReadingMeterType build() {
      try {
        ReadingMeterType record = new ReadingMeterType();
        record.meterID = fieldSetFlags()[0] ? this.meterID : (java.lang.Integer) defaultValue(fields()[0]);
        record.reading = fieldSetFlags()[1] ? this.reading : (java.lang.Float) defaultValue(fields()[1]);
        record.meterType = fieldSetFlags()[2] ? this.meterType : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.lastUpdate = fieldSetFlags()[3] ? this.lastUpdate : (java.time.Instant) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ReadingMeterType>
    WRITER$ = (org.apache.avro.io.DatumWriter<ReadingMeterType>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ReadingMeterType>
    READER$ = (org.apache.avro.io.DatumReader<ReadingMeterType>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










