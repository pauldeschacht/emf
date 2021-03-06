/**
 * Copyright (c) 2010 Ed Merks and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors: 
 *   Ed Merks - Initial API and implementation
 */
package org.eclipse.emf.ecore.resource;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * TODO
 */
@RemoteServiceRelativePath("uriService")
public interface URIService extends RemoteService
{
  Map<?, ?> fetch(String uri, Map<?, ?> options);
  Map<?, ?> store(String uri, byte[] bytes, Map<?, ?> options);
  Map<?, ?> delete(String uri, Map<?, ?> options);
  boolean exists(String uri, Map<?, ?> options);
  
  interface WhiteList
  {
    // A marker interface.
  }

  WhiteList whiteList(WhiteList whiteList);
}
