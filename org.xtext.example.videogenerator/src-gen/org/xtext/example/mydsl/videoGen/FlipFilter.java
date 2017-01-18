/**
 */
package org.xtext.example.mydsl.videoGen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flip Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.FlipFilter#getOrientation <em>Orientation</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getFlipFilter()
 * @model
 * @generated
 */
public interface FlipFilter extends Filter
{
  /**
   * Returns the value of the '<em><b>Orientation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orientation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orientation</em>' attribute.
   * @see #setOrientation(String)
   * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getFlipFilter_Orientation()
   * @model
   * @generated
   */
  String getOrientation();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.FlipFilter#getOrientation <em>Orientation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Orientation</em>' attribute.
   * @see #getOrientation()
   * @generated
   */
  void setOrientation(String value);

} // FlipFilter
