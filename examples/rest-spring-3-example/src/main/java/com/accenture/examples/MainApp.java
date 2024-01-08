/*

    Copyright 2018-2024 Accenture Technology

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package com.accenture.examples;

import org.platformlambda.core.annotations.MainApplication;
import org.platformlambda.core.models.EntryPoint;
import org.platformlambda.core.system.Platform;
import org.platformlambda.core.system.ServerPersonality;
import org.platformlambda.rest.RestServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MainApplication
public class MainApp implements EntryPoint {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        RestServer.main(args);
    }

    @Override
    public void start(String[] args) throws Exception {

        // Set personality to REST - this must be done in the beginning
        ServerPersonality.getInstance().setType(ServerPersonality.Type.REST);

        Platform platform = Platform.getInstance();
        /*
         * In application.properties, the "cloud.connector" is set to "none" when your
         * app is running in standalone mode.
         *
         * If you want to use a network event stream system to connect application service
         * instances together, you may configure "cloud.connector" to "kafka" or a connector
         * that you implement.
         *
         * When "cloud.connector" is set to "none", connectToCloud() method has no effect.
         */
        platform.connectToCloud();

        log.info("Application started");
    }

}
