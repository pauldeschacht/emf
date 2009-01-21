/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: Book.java,v 1.2 2006/12/30 03:43:52 marcelop Exp $
 */
package com.example.sdo.library;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.sdo.library.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link com.example.sdo.library.Book#getPages <em>Pages</em>}</li>
 *   <li>{@link com.example.sdo.library.Book#getCategory <em>Category</em>}</li>
 *   <li>{@link com.example.sdo.library.Book#getAuthor <em>Author</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.sdo.library.LibraryPackage#getBook()
 * @model
 * @generated
 */
public interface Book
{
  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see com.example.sdo.library.LibraryPackage#getBook_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link com.example.sdo.library.Book#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Pages</b></em>' attribute.
   * The default value is <code>"100"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pages</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pages</em>' attribute.
   * @see #setPages(int)
   * @see com.example.sdo.library.LibraryPackage#getBook_Pages()
   * @model default="100"
   * @generated
   */
  int getPages();

  /**
   * Sets the value of the '{@link com.example.sdo.library.Book#getPages <em>Pages</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pages</em>' attribute.
   * @see #getPages()
   * @generated
   */
  void setPages(int value);

  /**
   * Returns the value of the '<em><b>Category</b></em>' attribute.
   * The literals are from the enumeration {@link com.example.sdo.library.BookCategory}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Category</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Category</em>' attribute.
   * @see com.example.sdo.library.BookCategory
   * @see #setCategory(BookCategory)
   * @see com.example.sdo.library.LibraryPackage#getBook_Category()
   * @model
   * @generated
   */
  BookCategory getCategory();

  /**
   * Sets the value of the '{@link com.example.sdo.library.Book#getCategory <em>Category</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Category</em>' attribute.
   * @see com.example.sdo.library.BookCategory
   * @see #getCategory()
   * @generated
   */
  void setCategory(BookCategory value);

  /**
   * Returns the value of the '<em><b>Author</b></em>' reference.
   * It is bidirectional and its opposite is '{@link com.example.sdo.library.Writer#getBooks <em>Books</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Author</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Author</em>' reference.
   * @see #setAuthor(Writer)
   * @see com.example.sdo.library.LibraryPackage#getBook_Author()
   * @see com.example.sdo.library.Writer#getBooks
   * @model opposite="books" required="true"
   * @generated
   */
  Writer getAuthor();

  /**
   * Sets the value of the '{@link com.example.sdo.library.Book#getAuthor <em>Author</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Author</em>' reference.
   * @see #getAuthor()
   * @generated
   */
  void setAuthor(Writer value);

} // Book