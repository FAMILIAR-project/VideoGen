/**
 */
package org.xtext.example.mydsl.videoGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.Filter#getFilter <em>Filter</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getFilter()
 * @model
 * @generated
 */
public interface Filter extends EObject
{
  /**
   * Returns the value of the '<em><b>Filter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filter</em>' attribute.
   * @see #setFilter(String)
   * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getFilter_Filter()
   * @model
   * @generated
   */
  String getFilter();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.Filter#getFilter <em>Filter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filter</em>' attribute.
   * @see #getFilter()
   * @generated
   */
  void setFilter(String value);

} // Filter
