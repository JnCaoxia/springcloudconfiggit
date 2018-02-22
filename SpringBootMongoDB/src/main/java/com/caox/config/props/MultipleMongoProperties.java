package com.caox.config.props;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author neo
 */
@Data
@ConfigurationProperties(prefix = "mongodb")
// 封装读取以mongodb开头的两个配置文件
public class MultipleMongoProperties {

	private MongoProperties primary = new MongoProperties();
	private MongoProperties secondary = new MongoProperties();
}
