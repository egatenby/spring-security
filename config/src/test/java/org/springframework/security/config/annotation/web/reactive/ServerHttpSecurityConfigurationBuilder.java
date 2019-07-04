/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.config.annotation.web.reactive;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.users.ReactiveAuthenticationTestConfiguration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;

/**
 * @author Rob Winch
 * @since 5.0
 */
public class ServerHttpSecurityConfigurationBuilder {
	public static ServerHttpSecurity http() {
		return new ServerHttpSecurityConfiguration().httpSecurity();
	}

	public static ServerHttpSecurity httpWithDefaultAuthentication() {
		ReactiveUserDetailsService reactiveUserDetailsService = ReactiveAuthenticationTestConfiguration
			.userDetailsService();
		ReactiveAuthenticationManager authenticationManager = new UserDetailsRepositoryReactiveAuthenticationManager(
			reactiveUserDetailsService);
		return http()
			.authenticationManager(authenticationManager);
	}
}
