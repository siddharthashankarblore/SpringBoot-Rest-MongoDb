package com.mongodb.starter.models;

import java.util.Objects;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
@JsonInclude(Include.NON_NULL)
public class Quotes {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	private String type;
    private String quote;
    private String author;

    @Override
    public String toString() {
        return "Quotes{" + "type=" + type + ", quote='" + quote + '\'' + ", author='" + author + '}';
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id, type, author, quote);
    }
}
