/**
 */
package org.xtext.example.mydsl.videoGen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getAuthorName <em>Author Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getVersion <em>Version</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getCreationDate <em>Creation Date</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getVideoGenInformation()
 * @model
 * @generated
 */
public interface VideoGenInformation extends EObject
{
  /**
   * Returns the value of the '<em><b>Author Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Author Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Author Name</em>' attribute.
   * @see #setAuthorName(String)
   * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getVideoGenInformation_AuthorName()
   * @model
   * @generated
   */
  String getAuthorName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getAuthorName <em>Author Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Author Name</em>' attribute.
   * @see #getAuthorName()
   * @generated
   */
  void setAuthorName(String value);

  /**
   * Returns the value of the '<em><b>Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Version</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Version</em>' attribute.
   * @see #setVersion(String)
   * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getVideoGenInformation_Version()
   * @model
   * @generated
   */
  String getVersion();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getVersion <em>Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Version</em>' attribute.
   * @see #getVersion()
   * @generated
   */
  void setVersion(String value);

  /**
   * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Creation Date</em>' attribute.
   * @see #setCreationDate(String)
   * @see org.xtext.example.mydsl.videoGen.VideoGenPackage#getVideoGenInformation_CreationDate()
   * @model
   * @generated
   */
  String getCreationDate();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.videoGen.VideoGenInformation#getCreationDate <em>Creation Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Creation Date</em>' attribute.
   * @see #getCreationDate()
   * @generated
   */
  void setCreationDate(String value);

} // VideoGenInformation
