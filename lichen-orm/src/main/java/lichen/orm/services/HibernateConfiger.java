// Copyright 2011 the original author or authors.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package lichen.orm.services;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate的配置接口
 * @author jcai
 * @version 0.1
 */
public interface HibernateConfiger {
    /**
     * 针对Hibernate的配置
     * @param configuration hibernate配置接口
     * @see Configuration
     */
    public void config(Configuration configuration) throws HibernateException;
}
