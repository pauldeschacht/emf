/**
 * <copyright>
 * </copyright>
 *
 * $Id: WriterImpl.java,v 1.2 2006/07/07 17:22:36 marcelop Exp $
 */
package org.examples.library.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.examples.hr.impl.PersonImpl;

import org.examples.library.Book;
import org.examples.library.LibraryPackage;
import org.examples.library.Writer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Writer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.examples.library.impl.WriterImpl#getBooks <em>Books</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WriterImpl extends PersonImpl implements Writer
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String copyright = "This is my code.";

  /**
   * The cached value of the '{@link #getBooks() <em>Books</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBooks()
   * @generated
   * @ordered
   */
  protected EList books = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WriterImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return LibraryPackage.Literals.WRITER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList getBooks()
  {
    if (books == null)
    {
      books = new EObjectWithInverseResolvingEList(Book.class, this, LibraryPackage.WRITER__BOOKS, LibraryPackage.BOOK__AUTHOR);
    }
    return books;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LibraryPackage.WRITER__BOOKS:
        return ((InternalEList)getBooks()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LibraryPackage.WRITER__BOOKS:
        return ((InternalEList)getBooks()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LibraryPackage.WRITER__BOOKS:
        return getBooks();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LibraryPackage.WRITER__BOOKS:
        getBooks().clear();
        getBooks().addAll((Collection)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LibraryPackage.WRITER__BOOKS:
        getBooks().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LibraryPackage.WRITER__BOOKS:
        return books != null && !books.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //WriterImpl