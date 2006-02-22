/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: ModelConverterManager.java,v 1.2 2006/02/22 22:28:57 marcelop Exp $
 */
package org.eclipse.emf.converter.ui.contribution;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.framework.Bundle;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;


/**
 * @since 2.2.0
 */
public abstract class ModelConverterManager
{
  public static class ModelConverterDescriptorImpl implements ModelConverterDescriptor
  {
    protected String id;
    protected String name;
    protected Image icon;
    protected String description;
    
    protected IConfigurationElement configurationElement;

    public String getID()
    {
      return id;
    }

    public void setID(String id)
    {
      this.id = id;
    }

    public Image getIcon()
    {
      return icon;
    }

    public void setIcon(Image icon)
    {
      this.icon = icon;
    }

    public String getName()
    {
      return name;
    }

    public void setName(String name)
    {
      this.name = name;
    }

    public String getDescription()
    {
      return description;
    }

    public void setDescription(String description)
    {
      this.description = description;
    }
    
    protected Object createExecutableExtension(String attribute)
    {
      if (configurationElement != null)
      {
        try
        {
          return configurationElement.createExecutableExtension("wizard");
        }
        catch (Exception e)
        {
        }
      }
      return null;
    }
  }

  public static class ModelConverterDescriptorLabelProvider extends LabelProvider
  {
    public Image getImage(Object element)
    {
      if (element instanceof ModelConverterDescriptor)
      {
        return ((ModelConverterDescriptor)element).getIcon();
      }
      else
      {
        return super.getImage(element);
      }
    }

    public String getText(Object element)
    {
      if (element instanceof ModelConverterDescriptor)
      {
        return ((ModelConverterDescriptor)element).getName();
      }
      else
      {
        return super.getText(element);
      }
    }
  }

  public static abstract class ModelConverterDescriptorWizardNode implements IWizardNode
  {
    protected boolean contentCreated = false;
    protected ModelConverterDescriptor descriptor;
    protected IWizard wizard;
    protected Point point;

    public ModelConverterDescriptorWizardNode(ModelConverterDescriptor descriptor)
    {
      this.descriptor = descriptor;
    }

    public void dispose()
    {
      wizard = null;
      descriptor = null;
      point = null;
    }

    public IWizard getWizard()
    {
      if (wizard == null)
      {
        if (descriptor != null)
        {
          wizard = createWizard();
        }
      } 
      return wizard;
    }
    
    abstract protected IWizard createWizard();

    public boolean isContentCreated()
    {
      return contentCreated;
    }
    
    public void setContentCreated(boolean contentCreated)
    {
      this.contentCreated = contentCreated;
    }

    public Point getExtent()
    {
      if (point == null)
      {
        point = new Point(-1, -1);
      }
      return point;
    }
  }

  protected List descriptors;

  public void dispose()
  {
    if (descriptors != null)
    {
      descriptors.clear();
      descriptors = null;
    }
  }
  
  abstract protected ModelConverterDescriptorWizardNode createModelConverterDescriptorWizardNode(ModelConverterDescriptor descriptor);

  /**
   * @return a map in which the key is a {@link ModelConverterDescriptor} and 
   * the value is a {@link ModelConverterDescriptorWizardNode}
   */
  public Map createModelConverterDescriptorWizardNodeMap()
  {
    if (descriptors != null)
    {
      Map map = new HashMap();
      for (Iterator i = descriptors.iterator(); i.hasNext();)
      {
        ModelConverterDescriptor descriptor = (ModelConverterDescriptor)i.next();
        ModelConverterDescriptorWizardNode wizardNode = createModelConverterDescriptorWizardNode(descriptor);
        map.put(descriptor, wizardNode);
      }
      return map;
    }
    else
    {
      return Collections.EMPTY_MAP;
    }
  }

  public List getModelConverterDescriptors()
  {
    if (descriptors == null)
    {
      descriptors = retrieveContributedModelConverterDescriptors();
    }
    return descriptors;
  }

  public ModelConverterDescriptor getModelConverterDescriptor(String id)
  {
    if (id != null)
    {
      for (Iterator i = getModelConverterDescriptors().iterator(); i.hasNext();)
      {
        ModelConverterDescriptor descriptor = (ModelConverterDescriptor)i.next();
        if (id.equals(descriptor.getID()))
        {
          return descriptor;
        }
      }
    }
    return null;
  }
  
  abstract protected String getPluginId();
  abstract protected String getExtensionPointId();

  public List retrieveContributedModelConverterDescriptors()
  {
    List descriptors = new ArrayList();

    IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(getPluginId(), getExtensionPointId());
    IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();
    for (int i = 0; i < configurationElements.length; i++)
    {
      ModelConverterDescriptor descriptor = createFromContribution(configurationElements[i]);
      if (descriptor != null)
      {
        descriptors.add(descriptor);
      }
    }

    return descriptors;
  }
  
  abstract protected String getElementName();
  abstract protected ModelConverterDescriptorImpl createModelConverterDescriptorImpl();

  protected ModelConverterDescriptor createFromContribution(IConfigurationElement configurationElement)
  {
    if (getElementName().equals(configurationElement.getName()))
    {
      String id = configurationElement.getAttribute("id");
      String name = configurationElement.getAttribute("name");
      String wizard = configurationElement.getAttribute("wizard");
      if (id != null && name != null && wizard != null)
      {
        ModelConverterDescriptorImpl descriptorImpl = createModelConverterDescriptorImpl();
        descriptorImpl.setID(id);
        descriptorImpl.setName(name);
        descriptorImpl.setDescription(configurationElement.getAttribute("description"));
        descriptorImpl.configurationElement = configurationElement;

        String imageKey = configurationElement.getAttribute("icon");
        if (imageKey != null)
        {
          Bundle pluginBundle = Platform.getBundle(configurationElement.getDeclaringExtension().getContributor().getName());
          URL path = pluginBundle.getEntry("/");
          URL fullPathString = null;
          try
          {
            fullPathString = new URL(path, imageKey);
            ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(fullPathString);
            descriptorImpl.setIcon(imageDescriptor.createImage());
          }
          catch (Exception e)
          {
          }
        }

        return descriptorImpl;
      }
    }

    return null;
  }
}
