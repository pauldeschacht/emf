/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: GeneratedPackageRegistryReader.java,v 1.5 2006/02/22 22:28:56 marcelop Exp $
 */
package org.eclipse.emf.ecore.plugin;


import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

/**
 * A plugin extension reader that populates the
 * {@link org.eclipse.emf.ecore.EPackage.Registry#INSTANCE global} package registry.
 * Clients are not expected to use this class directly.
 */
class GeneratedPackageRegistryReader extends RegistryReader
{
  static final String TAG_PACKAGE = "package";
  static final String ATT_URI = "uri";
  static final String ATT_CLASS = "class";
  static final String ATT_GEN_MODEL = "genModel";
  
  protected Map ePackageNsURIToGenModelLocationMap;
  
  public GeneratedPackageRegistryReader()
  {
    super
      (Platform.getExtensionRegistry(),
       EcorePlugin.getPlugin().getBundle().getSymbolicName(), 
       EcorePlugin.GENERATED_PACKAGE_PPID);
  }
  
  public GeneratedPackageRegistryReader(Map ePackageNsURIToGenModelLocationMap)
  {
    this();
    this.ePackageNsURIToGenModelLocationMap = ePackageNsURIToGenModelLocationMap;
  }

  protected boolean readElement(IConfigurationElement element)
  {
    if (element.getName().equals(TAG_PACKAGE))
    {
      String packageURI = element.getAttribute(ATT_URI);
      if (packageURI == null)
      {
        logMissingAttribute(element, ATT_URI);
      }
      else if (element.getAttribute(ATT_CLASS) == null)
      {
        logMissingAttribute(element, ATT_CLASS);
      }
      else
      {
        EPackage.Registry.INSTANCE.put(packageURI, new EPackageDescriptor(element, ATT_CLASS));
        
        if (ePackageNsURIToGenModelLocationMap != null)
        {
          String genModel = element.getAttribute(ATT_GEN_MODEL);
          if (genModel != null)
          {
            URI genModelURI = URI.createURI(genModel);
            if (genModelURI.isRelative())
            {
              genModelURI = URI.createURI("platform:/plugin/" + element.getDeclaringExtension().getContributor().getName() + "/" + genModel);
            }
            ePackageNsURIToGenModelLocationMap.put(packageURI, genModelURI);
          }
        }
        return true;
      }
    }

    return false;
  }
}
