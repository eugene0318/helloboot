package tobyspring.study;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {
	@Test
	void configuration() {

	}

	static class Bean1 {
		private final Common common;

		public Bean1(Common common) {
			super();
			this.common = common;
		}

	}

	static class Bean2 {
		private final Common common;

		public Bean2(Common common) {
			super();
			this.common = common;
		}

	}

	static class Common {

	}

}
