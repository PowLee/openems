package io.openems.edge.core.host;

import io.openems.edge.common.host.Host;
import io.openems.edge.common.test.AbstractComponentConfig;

@SuppressWarnings("all")
public class MyConfig extends AbstractComponentConfig implements Config {

	protected static class Builder {
		public String networkConfiguration = null;
		public String usbConfiguration = null;

		private Builder() {
		}

		public Builder setNetworkConfiguration(String networkConfiguration) {
			this.networkConfiguration = networkConfiguration;
			return this;
		}

		public Builder setUsbConfiguration(String usbConfiguration) {
			this.usbConfiguration = usbConfiguration;
			return this;
		}

		public MyConfig build() {
			return new MyConfig(this);
		}
	}

	/**
	 * Create a Config builder.
	 * 
	 * @return a {@link Builder}
	 */
	public static Builder create() {
		return new Builder();
	}

	private final Builder builder;

	private MyConfig(Builder builder) {
		super(Config.class, Host.SINGLETON_COMPONENT_ID);
		this.builder = builder;
	}

	@Override
	public String networkConfiguration() {
		return this.builder.networkConfiguration;
	}

	@Override
	public String usbConfiguration() {
		return this.builder.usbConfiguration;
	}

}